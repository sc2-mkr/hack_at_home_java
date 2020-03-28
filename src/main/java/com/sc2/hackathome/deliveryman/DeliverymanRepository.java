package com.sc2.hackathome.deliveryman;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface DeliverymanRepository extends JpaRepository<Deliveryman, Long> {
}