package com.codingdojo.savetravels.repositories;

import com.codingdojo.savetravels.models.Travel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TravelRepository extends CrudRepository<Travel, Long> {
    List<Travel> findAll();
}
