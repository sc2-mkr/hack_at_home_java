package com.sc2.hackathome.shippinglist;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("text")
public class ShippingTextItem extends ShippingItem {
    @Column(name = "TEXT")
    private String text;
}
