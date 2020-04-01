package com.sc2.hackathome.configuration;

import com.sc2.hackathome.deliveryman.Deliveryman;
import com.sc2.hackathome.deliveryman.DeliverymanRepository;
import com.sc2.hackathome.shippinglist.ShippingItem;
import com.sc2.hackathome.shippinglist.ShippingList;
import com.sc2.hackathome.shippinglist.ShippingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
class LoadDatabase {

    @Bean
    @Autowired
    CommandLineRunner initDatabase(DeliverymanRepository deliverymanRepository,
                                   ShippingListRepository shippingListRepository) {
        return args -> {
//            deliverymanRepository.save(new Deliveryman(1, "Iregon", "Alessandro", "Tornesello"));
//            deliverymanRepository.save(new Deliveryman(2, "Deliveryman#2", "Pinco", "Pallino"));
//            deliverymanRepository.save(new Deliveryman(3, "admin", "Alessandro", "Tornesello"));
//
//            List<ShippingItem> list1 = new ArrayList<>();
//            list1.add(new ShippingItem(1, "3 confezioni di pasta"));
//
//            List<ShippingItem> list2 = new ArrayList<>();
//            list2.add(new ShippingItem(1, "1 scatoletta di tonno"));
//
//            List<ShippingItem> list3 = new ArrayList<>();
//            list3.add(new ShippingItem(1, "300g di macinato"));
//
//            shippingListRepository.save(new ShippingList(1, list1, 2, null, "Via Maria 13", "Lecce"));
//            shippingListRepository.save(new ShippingList(1, list2, 1, null, "Via Piemonte 43", "Matino"));
//            shippingListRepository.save(new ShippingList(1, list3, 1, null, "Via Roma 88", "Collepasso"));

        };
    }
}