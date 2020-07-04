package com.rest.registry.controllers;


import com.rest.registry.entities.Owner;
import com.rest.registry.entities.PropertyType;
import com.rest.registry.services.PropertyTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "propertyType")
@Tag(name = "Property type", description = "Manage property types of real estates")
public class PropertyTypeController {

    @Autowired
    PropertyTypeService propertyTypeService;

    @PostMapping
    @ResponseBody
    @Operation(summary = "Add/update property type to a database", description = "Insert a record in application/json format", tags = {"Property type"})
    public PropertyType addPropertyType(@RequestBody PropertyType propertyType){
        return propertyTypeService.addPropertyType(propertyType);
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    @Operation(summary = "Get property type by its id from a database", description = "Specify an id for the property type", tags = {"Property type"})
    public PropertyType getPropertyType (@PathVariable Integer id) {
        return propertyTypeService.getById(id);
    }

    @GetMapping
    @ResponseBody
    @Operation(summary = "Get all property types from a database", tags = {"Property type"})
    public List<PropertyType> getPropertyTypes (){
        return propertyTypeService.getPropertyTypes();
    }

    @DeleteMapping
    @Operation(summary = "Delete property type", description = "Specify property type", tags = {"Property type"})
    public void deletePropertyType(@RequestBody PropertyType propertyType){
        propertyTypeService.deletePropertyType(propertyType);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary = "Delete property type", description = "Specify property type id", tags = {"Property type"})
    public void deleteOwnerById(@PathVariable Integer id){
        propertyTypeService.deletePropertyTypeById(id);
    }
    @GetMapping(path = "/exists/{id}")
    @Operation(summary = "Check if property type exists", description = "Specify property type id", tags = {"Property type"})
    public boolean existsOwner(@PathVariable Integer id){
        return propertyTypeService.existsPropertyType(id);
    }
}
