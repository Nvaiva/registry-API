package com.rest.registry.services;

import com.rest.registry.entities.PropertyType;
import com.rest.registry.repositories.PropertyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyTypeService {
    @Autowired
    PropertyTypeRepository propertyTypeRepo;

    public PropertyTypeService(PropertyTypeRepository propertyTypeRepo) {
        this.propertyTypeRepo = propertyTypeRepo;
    }

    public PropertyType addPropertyType(PropertyType propertyType) {
        propertyTypeRepo.save(propertyType);
        return propertyType;
    }

    public PropertyType getById(Integer id) {
        PropertyType propertyType = propertyTypeRepo.getById(id);
        return propertyType;
    }

    public List<PropertyType> getPropertyTypes() {
        return propertyTypeRepo.findAll();
    }

    public void deletePropertyType(PropertyType propertyType) {
        propertyTypeRepo.delete(propertyType);
    }

    public void deletePropertyTypeById(Integer id) {
        propertyTypeRepo.deleteById(id);
    }

    public boolean existsPropertyType(Integer id) {
        return propertyTypeRepo.existsById(id);
    }
}
