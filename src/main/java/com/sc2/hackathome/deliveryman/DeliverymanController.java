package com.sc2.hackathome.deliveryman;


import com.sc2.hackathome.exceptions.NotFoundException;
import com.sc2.hackathome.shippinglist.ShippingList;
import com.sc2.hackathome.shippinglist.ShippingListRepository;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;

@RestController
public class DeliverymanController {

    private final DeliverymanRepository deliverymanRepository;
    private final ShippingListRepository shippingListRepository;

    public DeliverymanController(DeliverymanRepository deliverymanRepository, ShippingListRepository shippingListRepository) {
        this.deliverymanRepository = deliverymanRepository;
        this.shippingListRepository = shippingListRepository;
    }

    @GetMapping("/deliveryman/auth")
    public Deliveryman getDeliveryman(@RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass) {
        //todo return if email and password exist in database
        return new Deliveryman(1);
    }

    @PostMapping("/deliveryman/{id}/acceptshippinglist/")
    void newShippingList(@RequestParam Long id, @RequestBody Long idList) {
        ShippingList shippingList = shippingListRepository.findById(idList).orElseThrow(() -> new NotFoundException("deliveryman", id));
        shippingList.setDeliveryManId(id);
        shippingListRepository.save(shippingList);
    }

    @GetMapping("/deliveryman")
    Deliveryman x( ) {
        Deliveryman d = new Deliveryman(0,"mattia","mattia","mattia","mattia");
        return deliverymanRepository.findAll(Example.of(d)).get(0);
    }


    @GetMapping("/deliveryman/signin")
    public Deliveryman signinDeliveryman(@RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass,
                                         @RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname,
                                         @RequestParam(value = "id") Long id) {
        //todo check email not exist(or set email unique in database)
        //todo save data new deliveryman to database
        return new Deliveryman(1);
    }

    @GetMapping("/deliveryman/getallshippinglists")
    public Deliveryman getAllShippingLists(@RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass) {
        //todo auth user
        //todo return all shipping list foreigned key with deliveryman
        return new Deliveryman(1);//return shippinglist
    }

    @GetMapping("/deliveryman/getfromidshippinglist")
    public Deliveryman getFromIdShippingList(@RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass,
                                             @RequestParam(value = "id") Long id) {
        //todo auth user
        //todo return shipping list foreigned key with deliveryman by ID(shippinglist)
        return new Deliveryman(1);//return shippinglist
    }

}
