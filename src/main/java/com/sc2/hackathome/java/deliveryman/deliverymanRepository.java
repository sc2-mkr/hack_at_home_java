package com.sc2.hackathome.java.deliveryman;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface deliverymanRepository extends PagingAndSortingRepository<deliveryman, Long> {
    List<deliveryman> findByName(@Param("name") String name);
}