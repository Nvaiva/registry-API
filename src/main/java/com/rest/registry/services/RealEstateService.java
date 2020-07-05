package com.rest.registry.services;

import com.rest.registry.entities.RealEstate;
import com.rest.registry.repositories.RealEstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealEstateService {
    @Autowired
    RealEstateRepository realEstateRepo;

    public RealEstateService(RealEstateRepository realEstateRepo) {
        this.realEstateRepo = realEstateRepo;
    }

    public RealEstate addRealEstate(RealEstate realEstate) {
        realEstateRepo.save(realEstate);
        return realEstate;
    }

    public RealEstate getById(Integer id) {
        RealEstate realEstate = realEstateRepo.getById(id);
        return realEstate;
    }

    public List<RealEstate> getRealEstate() {
        return realEstateRepo.findAll();
    }

    public void deleteRealEstate(RealEstate realEstate) {
        realEstateRepo.delete(realEstate);
    }

    public void deleteRealEstateById(Integer id) {
        realEstateRepo.deleteById(id);
    }

    public boolean existsRealEstate(Integer id) {
        return realEstateRepo.existsById(id);
    }
}
