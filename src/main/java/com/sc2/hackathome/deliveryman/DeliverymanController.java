package com.sc2.hackathome.deliveryman;


import com.sc2.hackathome.shippinglist.ShippingList;
import com.sc2.hackathome.shippinglist.ShippingListRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeliverymanController {

    private final DeliverymanRepository deliverymanRepository;
    private final ShippingListRepository shippingListRepository;

    public DeliverymanController(DeliverymanRepository deliverymanRepository, ShippingListRepository shippingListRepository) {
        this.deliverymanRepository = deliverymanRepository;
        this.shippingListRepository = shippingListRepository;
    }

    @GetMapping("/deliverymans")
    List<Deliveryman> all() {
        return deliverymanRepository.findAll();
    }

    @GetMapping("/deliverymans/{id}")
    Deliveryman one(@PathVariable Long id) {
        return deliverymanRepository.findById(id)
                .orElseThrow(() -> new DeliverymanNotFoundException(id));
    }

    @GetMapping(value = "/deliverymans/{id}/acceptedShippingLists")
    List<ShippingList> acceptedShippingLists(@PathVariable Long id) {
        return shippingListRepository.findByDeliveryManId(id);
    }

    @PostMapping(value = "/deliverymans", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    Deliveryman newDeliveryman(@RequestBody Deliveryman newDeliveryman) {
        return deliverymanRepository.save(newDeliveryman);
    }

    @PutMapping(value = "/deliverymans/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    Deliveryman updateDeliveryman(@RequestBody Deliveryman newDeliveryman, @PathVariable Long id) {
        return deliverymanRepository.findById(id)
                .map(deliveryman -> {
                    deliveryman.setName(newDeliveryman.getName());
                    deliveryman.setSurname(newDeliveryman.getSurname());
                    deliveryman.setEmail(newDeliveryman.getEmail());
                    deliveryman.setPassword(newDeliveryman.getPassword());
                    return deliverymanRepository.save(deliveryman);
                })
                .orElseGet(() -> {
                    newDeliveryman.setId(id);
                    return deliverymanRepository.save(newDeliveryman);
                });
    }

    @DeleteMapping("/deliverymans/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteDeliveryman(@PathVariable Long id) {
        deliverymanRepository.deleteById(id);
    }
}
