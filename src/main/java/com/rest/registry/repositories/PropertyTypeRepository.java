package com.rest.registry.repositories;

import com.rest.registry.entities.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "propertyType")
public interface PropertyTypeRepository extends JpaRepository<PropertyType, Integer> {
    PropertyType getById(@Param("id") Integer id);
}
