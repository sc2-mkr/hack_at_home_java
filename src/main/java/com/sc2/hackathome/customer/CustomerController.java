package com.sc2.hackathome.customer;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private CustomerRepository repository;

    @GetMapping("/elderly/auth")
    public Customer getElderly(@RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass) {
        //todo return if email and password exist in database
        //repository.findByName(email);

        return new Customer(1);
    }

    @GetMapping("/elderly/signin")
    public Customer signinElderly(@RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass,
                                  @RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname,
                                  @RequestParam(value = "id") Long id) {
        //todo check email not exist(or set email unique in database)
        //todo save data new deliveryman to database
        return new Customer(1);
    }

    @GetMapping("/elderly/addshippinglists")
    public Customer addShippingList(@RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass) {
        //todo replace elderly with shipping list
        //todo return if email and password exist in database
        //repository.findByName(email);

        return new Customer(1);
    }

    @GetMapping("/elderly/getallshippinglists")
    public Customer getAllShippingLists(@RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass) {
        //todo auth user
        //todo return all shipping list foreigned key with deliveryman
        return new Customer(1);//return shippinglist
    }

    @GetMapping("/elderly/getfromidshippinglist")
    public Customer getFromIdShippingList(@RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass,
                                          @RequestParam(value = "id") Long id) {
        //todo auth user
        //todo return shipping list foreigned key with deliveryman by ID(shippinglist)
        return new Customer(1);//return shippinglist
    }

}
