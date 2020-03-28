package com.sc2.hackathome.shippinglist;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Inheritance
@DiscriminatorColumn(name = "SHIPPING_TYPE")
@Table(name="SHIPPING_ITEM")
public abstract class ShippingItem {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
}
