package com.sc2.hackathome.elderly;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "elderly", path = "elderly")
public interface ElderlyRepository extends JpaRepository<Elderly, Long> {
    List<Elderly> findByName(@Param("name") String name);
}