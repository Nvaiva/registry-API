package com.rest.registry.services;

import com.rest.registry.entities.Owner;
import com.rest.registry.entities.RealEstate;
import com.rest.registry.repositories.OwnerRepository;
import com.rest.registry.repositories.RealEstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class OwnerService {
    @Autowired
    OwnerRepository ownerRepo;

    @Autowired
    RealEstateRepository realEstateRepo;

    public OwnerService(OwnerRepository ownerRepo, RealEstateRepository realEstateRepo) {
        this.ownerRepo = ownerRepo;
        this.realEstateRepo = realEstateRepo;
    }

    public Owner addOwner(Owner owner) {
        ownerRepo.save(owner);
        return owner;
    }

    public Owner getById(Integer id) {
        return ownerRepo.getById(id);

    }

    public List<Owner> getOwners() {
        return ownerRepo.findAll();
    }

    public void deleteOwner(Owner owner) {
        ownerRepo.delete(owner);
    }

    public void deleteOwnerById(Integer id) {
        ownerRepo.deleteById(id);
    }

    public boolean existsOwner(Integer id) {
        return ownerRepo.existsById(id);
    }

    public String getTotalTaxes(Integer id) {

            Owner owner = ownerRepo.getById(id);
            if (owner == null) return "This onwer does not exist";

            Set<RealEstate> realEstates = realEstateRepo.getByOwners(owner);
            if (realEstates.size() == 0) return "This owner does not have any real estates";

            BigDecimal result = new BigDecimal(0.0);

            for (RealEstate re : realEstates) {
                result = result.add(re.getMarketValue().multiply(re.getPropertyType().getTaxRate()));
            }
            return result.toString();

    }
}
