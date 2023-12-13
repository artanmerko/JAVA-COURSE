package com.codingdojo.dojoandninjas.repositories;

import com.codingdojo.dojoandninjas.models.Ninja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepo extends CrudRepository<Ninja, Long> {

}