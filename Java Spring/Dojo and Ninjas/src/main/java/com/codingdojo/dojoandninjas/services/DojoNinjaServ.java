package com.codingdojo.dojoandninjas.services;

import com.codingdojo.dojoandninjas.models.Dojo;
import com.codingdojo.dojoandninjas.models.Ninja;
import com.codingdojo.dojoandninjas.repositories.DojoRepo;
import com.codingdojo.dojoandninjas.repositories.NinjaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DojoNinjaServ {
    private final DojoRepo dojoRepo;
    private final NinjaRepo ninjaRepo;

    public DojoNinjaServ(DojoRepo dojoRepo, NinjaRepo ninjaRepo) {
        this.dojoRepo = dojoRepo;
        this.ninjaRepo = ninjaRepo;
    }

    public void addDojo(Dojo dojo) {
        dojoRepo.save(dojo);
    }

    public List<Dojo> getAllDojos() {
        return dojoRepo.findAll();
    }

    public Dojo singleDojo(Long id) {
        Optional<Dojo> dojo = dojoRepo.findById(id);
        if(dojo.isPresent()) {
            return dojo.get();
        }
        else {
            return null;
        }
    }

    public void addNinja(Ninja ninja) {
        ninjaRepo.save(ninja);
    }
}