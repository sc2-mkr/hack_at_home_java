package com.sc2.hackathome.shippinglist;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "SHIPPING_ITEM")
public class ShippingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "PHOTO_URL")
    private String photoUrl;
    @Column(name = "TEXT")
    private String text;
}
