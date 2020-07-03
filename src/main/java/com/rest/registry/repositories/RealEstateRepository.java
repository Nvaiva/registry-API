package com.rest.registry.repositories;

import com.rest.registry.entities.Owner;
import com.rest.registry.entities.RealEstate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Set;

@RepositoryRestResource(path = "realEstate")
public interface RealEstateRepository extends JpaRepository<RealEstate, Integer> {
    List<RealEstate> getByCity(@Param("city") String city);

    List<RealEstate> getByStreet(@Param("street") String street);

    List<RealEstate> getByNumber(@Param("number") Integer number);

    List<RealEstate> getByPropertyType_id(@Param("propertyType") Integer propertyType);

    Set<RealEstate> getByOwners(@Param("owner")Owner owner);

    RealEstate getById (@Param ("id") Integer id);
}
