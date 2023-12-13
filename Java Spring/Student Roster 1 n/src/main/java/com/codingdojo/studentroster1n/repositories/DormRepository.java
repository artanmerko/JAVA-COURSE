package com.codingdojo.studentroster1n.repositories;

import com.codingdojo.studentroster1n.models.Dorm;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DormRepository extends CrudRepository<Dorm, Long> {
    List<Dorm> findAll();
}
