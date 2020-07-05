package com.rest.registry.repositories;

import com.rest.registry.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "owner")
public interface OwnerRepository extends JpaRepository<Owner, Integer> {

    Owner getById(@Param("id") Integer id);

    /* VERY INACCURATE ANSWER
    @Query(value = "SELECT SUM (realEstate.market_value * propertyType.tax_rate) " +
            "FROM owner INNER JOIN building_owner ON owner.id = building_owner.fk_owner " +
            "INNER JOIN realEstate ON building_owner.fk_real_estate = realEstate.id " +
            "INNER JOIN propertyType ON  realEstate.propertyType_id = propertyType.id " +
            "WHERE owner.ID = :id", nativeQuery = true)
    BigDecimal getByTotalTaxes(@Param("id") Integer id);*/


}
