package com.rest.registry.controllers;

import com.rest.registry.entities.Owner;
import com.rest.registry.services.OwnerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path = "owner")
@Tag(name = "Owner", description = "Manage owners data in database")
public class OwnerController {

    @Autowired
    OwnerService ownerService;


    @PostMapping
    @ResponseBody
    @Operation(summary = "Add/update owner to a database", description = "Insert a record in application/json format", tags = {"Owner"})
    public Owner addOwner(@RequestBody Owner owner) {
        return ownerService.addOwner(owner);

    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    @Operation(summary = "Get owner by its id from a database", description = "Specify an id for the owner", tags = {"Owner"})
    public Owner getOwner(@Valid @PathVariable Integer id) {
        Owner owner = ownerService.getById(id);
        return owner;
    }

    @GetMapping
    @ResponseBody
    @Operation(summary = "Get all owners from a database", tags = {"Owner"})
    public List<Owner> getOwners() {
        return ownerService.getOwners();
    }

    @DeleteMapping
    @Operation(summary = "Delete owner", description = "Specify owner", tags = {"Owner"})
    public void deleteOwner(@RequestBody Owner owner) {
        ownerService.deleteOwner(owner);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary = "Delete owner", description = "Specify owners id", tags = {"Owner"})
    public void deleteOwnerById(@PathVariable Integer id) {
        ownerService.deleteOwnerById(id);
    }

    @GetMapping(path = "/exists/{id}")
    @Operation(summary = "Check if owner exists", description = "Specify owners id", tags = {"Owner"})
    public boolean existsOwner(@PathVariable Integer id) {
        return ownerService.existsOwner(id);
    }

    @GetMapping(path = "/ownersTotalTaxes/{id}")
    @Operation(summary = "Get the amount of all taxes for a specified owner", description = "Specify owners id", tags = {"Owner"})
    public String totalTaxes(@PathVariable Integer id) {
        return "Taxes for owner " + id + "  = " + ownerService.getTotalTaxes(id);
    }


}
