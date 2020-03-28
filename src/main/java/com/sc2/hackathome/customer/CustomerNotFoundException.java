package com.sc2.hackathome.customer;

import com.sc2.hackathome.exceptions.NotFoundException;

public class CustomerNotFoundException extends NotFoundException {
    public CustomerNotFoundException(Long id) {
        super("customer", id);
    }
}
