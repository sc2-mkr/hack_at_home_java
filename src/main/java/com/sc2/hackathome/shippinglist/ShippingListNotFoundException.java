package com.sc2.hackathome.shippinglist;

import com.sc2.hackathome.exceptions.NotFoundException;

public class ShippingListNotFoundException extends NotFoundException {
    public ShippingListNotFoundException(Long id) {
        super("shipping list", id);
    }
}