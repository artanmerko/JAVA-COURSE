package com.codingdojo.dojoandninjas.repositories;

import com.codingdojo.dojoandninjas.models.Dojo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DojoRepo extends CrudRepository<Dojo, Long> {
    List<Dojo> findAll();
}
