package com.rest.registry.repositories;

import com.rest.registry.entities.Owner;
import com.rest.registry.entities.RealEstate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Set;

@RepositoryRestResource(path = "realEstate")
public interface RealEstateRepository extends JpaRepository<RealEstate, Integer> {
    Set<RealEstate> getByOwners(@Param("owner") Owner owner);

    RealEstate getById(@Param("id") Integer id);
}
