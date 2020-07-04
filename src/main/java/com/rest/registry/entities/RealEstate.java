package com.rest.registry.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "RealEstate")
@Table(name = "realestate",
        uniqueConstraints = @UniqueConstraint
                (columnNames = {"city", "street", "number", "propertytype_id"}))
public class RealEstate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column
    @NotNull(message = "City of the real estate is required")
    String city;
    @Column
    @NotNull(message = "Street of the real estate is required")
    String street;
    @Column
    @NotNull(message = "Number of real estate is required")
    Integer number;

    @Column
    @NotNull(message = "Size of the real estate is required (square meters)")
    Double size;

    @Column
    @NotNull(message = "Market value of the real estate is required")
    BigDecimal marketValue;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "buildingOwner",
            joinColumns = {@JoinColumn(name = "fk_realEstate", referencedColumnName = "id"),},
            inverseJoinColumns = {@JoinColumn(name = "fk_owner", referencedColumnName = "id")}
    )
    Set<Owner> owners = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "propertytype_id", referencedColumnName = "id")
    PropertyType propertyType;

    public RealEstate() {
    }

    public RealEstate(@NotNull(message = "City of the real estate is required") String city, @NotNull(message = "Street of the real estate is required") String street, @NotNull(message = "Number of real estate is required") Integer number, @NotNull(message = "Size of the real estate is required (square meters)") Double size, BigDecimal marketValue, Set<Owner> owners, PropertyType propertyType) {
        this.city = city;
        this.street = street;
        this.number = number;
        this.size = size;
        this.marketValue = marketValue;
        this.owners = owners;
        this.propertyType = propertyType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public BigDecimal getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(BigDecimal marketValue) {
        this.marketValue = marketValue;
    }

    @JsonIgnore
    public Set<Owner> getOwners() {
        return owners;
    }

    public void setOwners(Set<Owner> owners) {
        this.owners = owners;
    }

}
