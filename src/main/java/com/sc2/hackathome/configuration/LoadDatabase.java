package com.sc2.hackathome.configuration;

import com.sc2.hackathome.deliveryman.Deliveryman;
import com.sc2.hackathome.deliveryman.DeliverymanRepository;
import com.sc2.hackathome.shippinglist.ShippingList;
import com.sc2.hackathome.shippinglist.ShippingListRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(DeliverymanRepository deliverymanRepository,
                                   ShippingListRepository shippingListRepository) {
        return args -> {
            deliverymanRepository.save(new Deliveryman(1, "Iregon", "Alessandro", "Tornesello", "123456"));
            deliverymanRepository.save(new Deliveryman(2, "Deliveryman#2", "Pinco", "Pallino", "123456"));
            deliverymanRepository.save(new Deliveryman(3, "admin", "Alessandro", "Tornesello", "admin"));
            shippingListRepository.save(new ShippingList(1,2,1));
        };
    }
}