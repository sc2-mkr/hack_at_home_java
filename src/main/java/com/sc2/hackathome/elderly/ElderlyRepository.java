package com.sc2.hackathome.elderly;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface ElderlyRepository extends PagingAndSortingRepository<Elderly, Long> {
    List<Elderly> findByName(@Param("name") String name);
}