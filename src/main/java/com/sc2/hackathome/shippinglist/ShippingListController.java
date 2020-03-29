package com.sc2.hackathome.shippinglist;

import com.sc2.hackathome.exceptions.FileNotFoundException;
import com.sc2.hackathome.shippinglist.dto.ShippingListDto;
import com.sc2.hackathome.storage.StorageService;
import com.sc2.hackathome.user.UserService;
import com.sc2.hackathome.utils.FileUtils;
import org.springframework.core.io.Resource;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.MessageFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    List<ShippingList> all(@RequestParam(name = "shippingItemsLimit", required = false) Integer shippingItemsLimit) {
        List<ShippingList> list = repository.findAll();

        if (shippingItemsLimit != null)
            list.forEach(shippingList -> shippingList.setShippingItems(
                    shippingList.getShippingItems().stream().
                            limit(shippingItemsLimit)
                            .collect(Collectors.toList())));

        return list;
    }

    @PostMapping(value = "/shippinglists")
    ShippingList newShippingList(@RequestBody ShippingListDto shippingList) {
        ShippingList s = new ShippingList();
        s.setCity(shippingList.getCity());
        s.setAddress(shippingList.getAddress());
        s.setCustomerId(userService.getCurrentUser().getId());
        return repository.save(s);
    }
  
    @GetMapping("/shippinglists/city/{city}")
    List<ShippingList> getShippingListsByCity(@PathVariable String city) {
        List<ShippingList> list = new ArrayList<>();

        repository.findByCity(city).forEach(shippingList -> {
            if(shippingList.getDeliveryManId() == null) list.add(shippingList);
        });

        return list;
    }

    @GetMapping("/shippinglists/{id}")
    ShippingList one(@PathVariable Long id) {
        return getShippingListOrFail(id);
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

    private ShippingList getShippingListOrFail(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ShippingListNotFoundException(id));
    }

    @PostMapping(value = "/shippinglists/{id}/items", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ShippingList newShippingItem(
            @PathVariable Long id,
            @RequestBody(required = false) MultipartFile img,
            @RequestParam(required = false, name = "text") String text
//            @RequestPart(value = "item", required = false) ShippingItem item
    ) {

        ShippingList shippingList = getShippingListOrFail(id);
        String photoUrl = Optional.ofNullable(img)
                .flatMap(storageService::store)
                .map(filename -> MessageFormat.format("/shippinglists/{0}/img/{1}", id, filename))
                .orElse(null);

        ShippingItem item = new ShippingItem();
        item.setText(text);
        item.setPhotoUrl(photoUrl);
        shippingList.getShippingItems().add(item);
        return repository.save(shippingList);
    }

    @GetMapping(value = "/shippinglists/{id}/img/{filename}")
    ResponseEntity<byte[]> serveShippingItemImage(@PathVariable Long id, @PathVariable String filename) {
        //TODO authorize
        Resource resource = storageService.loadAsResource(filename)
                .orElseThrow(FileNotFoundException::new);

        return ResponseEntity.ok()
                .header(CacheControl.maxAge(Duration.ofDays(5)).getHeaderValue())
                .contentType(MediaTypeFactory.getMediaType(resource).get())
                .body(FileUtils.toByteArray(resource));
    }
}
