package com.sc2.hackathome.shippinglist;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShippingListController {
    private final ShippingListRepository repository;

    public ShippingListController(ShippingListRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/shippingLists")
    List<ShippingList> all() {
        return repository.findAll();
    }

    @PostMapping("/shippingLists")
    ShippingList newShippingList(@RequestBody ShippingList newShippingList) {
        return repository.save(newShippingList);
    }

    // Single item

    @GetMapping("/shippingLists/{id}")
    ShippingList one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ShippingListNotFoundException(id));
    }

    @PutMapping("/shippingLists/{id}")
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

    @DeleteMapping("/shippingLists/{id}")
    void deleteShippingList(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
