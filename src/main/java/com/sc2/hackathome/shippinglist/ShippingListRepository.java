package com.sc2.hackathome.shippinglist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShippingListRepository extends JpaRepository<ShippingList, Long> {
    List<ShippingList> findByDeliveryManId(Long id);

    List<ShippingList> findByCity(String city);
}
