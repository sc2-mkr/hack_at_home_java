package com.sc2.hackathome.deliveryman;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliverymanController {

    private DeliverymanRepository repository;

    @GetMapping("/deliveryman/auth")
    public Deliveryman getDeliveryman(@RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass) {
        //todo return if email and password exist in database
        repository.findByName(email);

        return new Deliveryman(1);
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
