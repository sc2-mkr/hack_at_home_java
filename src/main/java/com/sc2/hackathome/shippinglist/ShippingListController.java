package com.sc2.hackathome.shippinglist;

import com.sc2.hackathome.storage.StorageService;
import com.sc2.hackathome.user.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
public class ShippingListController {
    private final ShippingListRepository repository;
    private final StorageService storageService;
    private final UserService userService;

    public ShippingListController(ShippingListRepository repository, StorageService storageService, UserService userService) {
        this.repository = repository;
        this.storageService = storageService;
        this.userService = userService;
    }

    @GetMapping("/shippinglists")
    List<ShippingList> all() {
        return repository.findAll();
    }

    @PostMapping("/shippinglists")
    ShippingList newShippingList() {
        ShippingList shippingList = new ShippingList();
        shippingList.setCustomerId(userService.getCurrentUser().getId());
        return repository.save(shippingList);
    }

    @PostMapping(value = "/shippinglists/{id}/items", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ShippingList newShippingItem(
            @PathVariable Long id,
            @RequestPart(value = "img", required = false) MultipartFile image,
            @RequestPart(value = "item", required = false) ShippingItem item) {

        ShippingList shippingList = repository.findById(id).orElseThrow(() -> new ShippingListNotFoundException(id));
        String photoUrl = Optional.ofNullable(image)
                .flatMap(storageService::store)
                .orElse(null);

        if (item == null) item = new ShippingItem();
        item.setPhotoUrl(photoUrl);
        shippingList.getShippingItems().add(item);
        return repository.save(shippingList);
    }

    @GetMapping("/shippinglists/{id}")
    ShippingList one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ShippingListNotFoundException(id));
    }

    @PutMapping("/shippinglists/{id}")
    ShippingList replaceShippingList(@RequestBody ShippingList newShippingList, @PathVariable Long id) {
        return repository.findById(id)
                .map(shippingList -> {
                    shippingList.setShippingItems(newShippingList.getShippingItems());
                    return repository.save(shippingList);
                })
                .orElseGet(() -> {
                    newShippingList.setId(id);
                    return repository.save(newShippingList);
                });
    }

    @DeleteMapping("/shippinglists/{id}")
    void deleteShippingList(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
