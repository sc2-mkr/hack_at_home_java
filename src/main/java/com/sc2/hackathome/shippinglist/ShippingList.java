package com.sc2.hackathome.shippinglist;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "SHIPPING_LIST")
public class ShippingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "SHIPPING_ID", nullable = false)
    private List<ShippingItem> shippingItems;

    @Column(name = "CUSTOMER_ID")
    @NotNull
    private Long customerId;
    @Column(name = "DELIVERY_MAN_ID")
    private Long deliveryManId;

    @Column(name = "ADDRESS")
    @NotNull
    private String address;
    @Column(name = "CITY")
    @NotNull
    private String city;


    public ShippingList() {
        shippingItems = new ArrayList<>();
    }

    public ShippingList(long id, @NotNull long customerId, long deliveryManId) {
        this.id = id;
        this.shippingItems = new ArrayList<>();
        this.customerId = customerId;
        this.deliveryManId = deliveryManId;
    }

    public ShippingList(long id, List<ShippingItem> shippingItems, @NotNull long customerId, Long deliveryManId, @NotNull String address, @NotNull String city) {
        this.id = id;
        this.shippingItems = shippingItems;
        this.customerId = customerId;
        this.deliveryManId = deliveryManId;
        this.address = address;
        this.city = city;
    }
}
