package com.rest.registry;

import com.rest.registry.entities.Owner;
import com.rest.registry.entities.PropertyType;
import com.rest.registry.entities.RealEstate;
import com.rest.registry.repositories.OwnerRepository;
import com.rest.registry.repositories.PropertyTypeRepository;
import com.rest.registry.repositories.RealEstateRepository;
import com.rest.registry.services.OwnerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OwnerTest {

    @MockBean
    private OwnerRepository ownerRepository;
    @MockBean
    private PropertyTypeRepository propertyTypeRepository;
    @MockBean
    private RealEstateRepository realEstateRepository;

    @Autowired
    private OwnerService ownerService = new OwnerService(ownerRepository, realEstateRepository);

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getOwnerTest() {
        when(ownerRepository.findAll()).thenReturn(Stream.of(new Owner("Vaiva", "Nostyte")).collect(Collectors.toList()));
        assertEquals(1, ownerService.getOwners().size());

    }

    @Test
    public void getOwnerTest2() {
        when(ownerRepository.findAll()).thenReturn(Stream.of(new Owner("Vaiva", "Nostyte"), new Owner("John", "smith")).collect(Collectors.toList()));
        assertEquals(2, ownerService.getOwners().size());

    }

    @Test
    public void getOwnerByIdTest(){
        Owner owner = new Owner("Vaiva", "Nostyte");
        when(ownerRepository.getById(1)).thenReturn(owner);
        ownerRepository.save(owner);
        assertEquals(owner, ownerService.getById(1));
    }

  /* @Test
    public void testGetTaxes() {
        BigDecimal expectedValue;
        BigDecimal MARKET_VALUE_1 = new BigDecimal(10000000);
        BigDecimal MARKET_VALUE_2 = new BigDecimal(676676723.12);
        BigDecimal TAX_RATE_1 = new BigDecimal(0.89);
        BigDecimal TAX_RATE_2 = new BigDecimal(0.21);
        //create owner
        Set<Owner> ownerSet = new HashSet<>();
        Owner owner = new Owner("Vaiva", "Nostyte");
        ownerSet.add(owner);
        ownerRepository.save(owner);

        //create propertyTypes
        PropertyType propertyType1 = new PropertyType("Residiential", TAX_RATE_1);
        PropertyType propertyType2 = new PropertyType("Industrial", TAX_RATE_2);
        propertyTypeRepository.save(propertyType1);
        propertyTypeRepository.save(propertyType2);

        //create real estates
        RealEstate realEstate1 = new RealEstate("Kaunas", "Kauno", 12, 12.1, MARKET_VALUE_1, ownerSet, propertyType1);
        RealEstate realEstate2 = new RealEstate("Vilnius", "Kauno", 12, 12.0, MARKET_VALUE_2, ownerSet, propertyType2);
        realEstateRepository.save(realEstate1);
        realEstateRepository.save(realEstate2);
        Set<RealEstate> realEstates = new HashSet<>();
        realEstates.add(realEstate1);
        realEstates.add(realEstate2);

        owner.setRealEstates(realEstates);

        expectedValue = new BigDecimal(String.valueOf(MARKET_VALUE_1.multiply(TAX_RATE_1).add(MARKET_VALUE_2.multiply(TAX_RATE_2))));
        assertEquals(expectedValue, ownerService.getTotalTaxes(1));
    }*/


}
