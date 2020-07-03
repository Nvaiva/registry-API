package com.rest.registry.repositories;

import com.rest.registry.entities.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "propertyType")
public interface PropertyTypeRepository extends JpaRepository<PropertyType, Integer> {
    List<PropertyType> getByType(@Param("type") String type);
    PropertyType getById(@Param("id") Integer id);
    List<PropertyType> getByTaxRate(@Param("taxRate") String taxRate);

}
