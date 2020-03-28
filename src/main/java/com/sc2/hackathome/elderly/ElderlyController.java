package com.sc2.hackathome.elderly;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ElderlyController {

    private ElderlyRepository repository;

    @GetMapping("/deliveryman/auth")
    public Elderly getDeliveryman(@RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass) {
        //todo return if email and password exist in database
        repository.findByName(email);

        return new Elderly(1);
    }

    @GetMapping("/deliveryman/signin")
    public Elderly signinDeliveryman(@RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass,
                                     @RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname,
                                     @RequestParam(value = "id") Long id) {
        //todo check email not exist(or set email unique in database)
        //todo save data new deliveryman to database
        return new Elderly(1);
    }

    @GetMapping("/deliveryman/getallshippinglists")
    public Elderly getAllShippingLists(@RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass) {
        //todo auth user
        //todo return all shipping list foreigned key with deliveryman
        return new Elderly(1);//return shippinglist
    }

    @GetMapping("/deliveryman/getfromidshippinglist")
    public Elderly getFromIdShippingList(@RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass,
                                         @RequestParam(value = "id") Long id) {
        //todo auth user
        //todo return shipping list foreigned key with deliveryman by ID(shippinglist)
        return new Elderly(1);//return shippinglist
    }

}
