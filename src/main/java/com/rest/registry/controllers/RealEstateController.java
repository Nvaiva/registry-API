package com.rest.registry.controllers;

import com.rest.registry.entities.PropertyType;
import com.rest.registry.entities.RealEstate;
import com.rest.registry.services.PropertyTypeService;
import com.rest.registry.services.RealEstateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "RealEstate")
@Tag(name = "Real estate", description = "Manage real estates")
public class RealEstateController {
    @Autowired
    RealEstateService realEstateService;

    @PostMapping
    @ResponseBody
    @Operation(summary = "Add/update real estate to a database", description = "Insert a record in application/json format", tags = {"Real estate"})
    public RealEstate addPropertyType(@RequestBody RealEstate realEstate){
        return realEstateService.addRealEstate(realEstate);
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    @Operation(summary = "Get real estate by its id from a database", description = "Specify an id for the real estate", tags = {"Real estate"})
    public RealEstate getRealEstate (@PathVariable Integer id) {
        return realEstateService.getById(id);
    }

    @GetMapping
    @ResponseBody
    @Operation(summary = "Get all real estates from a database", tags = {"Real estate"})
    public List<RealEstate> getRealEstates (){
        return realEstateService.getRealEstate();
    }

    @DeleteMapping
    @Operation(summary = "Delete real estate", description = "Specify real estate", tags = {"Real estate"})
    public void deleteRealEstate(@RequestBody RealEstate realEstate){
        realEstateService.deleteRealEstate(realEstate);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary = "Delete real estate", description = "Specify real estate id", tags = {"Real estate"})
    public void deleteRealEstateById(@PathVariable Integer id){
        realEstateService.deleteRealEstateById(id);
    }
    @GetMapping(path = "/exists/{id}")
    @Operation(summary = "Check if real estate exists", description = "Specify real estate id", tags = {"Real estate"})
    public boolean existsRealEstate(@PathVariable Integer id){
        return realEstateService.existsRealEstate(id);
    }
}
