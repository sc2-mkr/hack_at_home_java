package com.sc2.hackathome.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/customers")
    List<Customer> all() {
        return repository.findAll();
    }

    @PostMapping("/customers")
    Customer newCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    // Single item

    @GetMapping("/customers/{id}")
    Customer one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    //    @PutMapping("/customers/{id}")
//    Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {
//
//        return repository.findById(id)
//                .map(shippingList -> {
//                    shippingList.setShippingItems(newCustomer.getShippingItems());
//                    return repository.save(shippingList);
//                })
//                .orElseGet(() -> {
//                    newCustomer.setId(id);
//                    return repository.save(newCustomer);
//                });
//    }

    @PutMapping("/customers/{id}")
    Customer replaceCustomer(@RequestParam(value = "address", defaultValue = "") String newAddress, @PathVariable Long id) {

        return repository.findById(id)
                .map(customer -> {
                    customer.setAddress(newAddress);
                    return repository.save(customer);
                })
                .orElseThrow(() -> {
                    return new CustomerNotFoundException(id);
                });
    }

    @DeleteMapping("/customers/{id}")
    void deleteCustomer(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
