package com.rest.registry.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column
    @NotBlank(message = "The name is required")
    String firstName;
    @Column
    @NotBlank(message = "The last name is required")
    String lastName;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "owners")
    Set<RealEstate> realEstates = new HashSet<>();

    public Owner(@NotBlank(message = "The name is required") String firstName, @NotBlank(message = "The last name is required") String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Set<RealEstate> getRealEstates() {
        return realEstates;
    }

    public void setRealEstates(Set<RealEstate> realEstates) {
        this.realEstates = realEstates;
    }

    public Owner() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //we use this method for better looking outputs
    @Override
    public String toString() {
        return "Owner \n" +
                "First name: " + firstName + "\n" +
                "Last name: " + lastName + "\n";
    }

}
