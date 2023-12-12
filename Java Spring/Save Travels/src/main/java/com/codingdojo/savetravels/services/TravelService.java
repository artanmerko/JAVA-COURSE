package com.codingdojo.savetravels.services;

import com.codingdojo.savetravels.models.Travel;
import com.codingdojo.savetravels.repositories.TravelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravelService {
    private final TravelRepository travelRepo;

    public TravelService(TravelRepository travel) {
        this.travelRepo = travel;
    }
    public List<Travel> allTravels() {
        return travelRepo.findAll();
    }
    public Travel addTravel(Travel travel) {
        return travelRepo.save(travel);
    }
    public Travel findTravel(Long id) {
        Optional<Travel> travel = travelRepo.findById(id);
        if(travel.isPresent()){
            return travel.get();
        } else {
            return null;
        }
    }
    public Travel updateTravel(Travel travel){
        return travelRepo.save(travel);
    }
    public void deleteTravel(Long id){
        travelRepo.deleteById(id);
    }
}
