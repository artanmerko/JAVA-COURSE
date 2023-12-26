package com.codingdojo.studentroster.repositories;

import com.codingdojo.studentroster.models.Dorm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DormRepository extends CrudRepository<Dorm, Long> {
    List<Dorm> findAll();
}