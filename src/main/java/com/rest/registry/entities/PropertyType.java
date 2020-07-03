package com.rest.registry.entities;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "propertytype", uniqueConstraints = @UniqueConstraint(columnNames = {"type", "taxrate"}))
public class PropertyType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column
    @NotNull(message = "Property type is required")
    String type;
    @Column
    @NotNull(message = "Tax rate for the specified property is required")
    BigDecimal taxRate;

    @JsonIgnore
    @OneToMany(mappedBy = "propertyType")
    Set<RealEstate> realEstates;

    public PropertyType(String type, BigDecimal taxRate) {
        this.type = type;
        this.taxRate = taxRate;
    }

    public PropertyType() {
    }

    public Set<RealEstate> getRealEstates() {
        return realEstates;
    }

    public void setRealEstates(Set<RealEstate> realEstates) {
        this.realEstates = realEstates;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }
}
