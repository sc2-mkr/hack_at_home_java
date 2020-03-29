package com.sc2.hackathome.deliveryman;

import com.sc2.hackathome.exceptions.NotFoundException;

public class DeliverymanNotFoundException extends NotFoundException {
    public DeliverymanNotFoundException(Long id) {
        super("deliveryman", id);
    }
}
