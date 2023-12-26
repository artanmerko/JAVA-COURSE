package com.codingdojo.studentroster.repositories;

import com.codingdojo.studentroster.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findAll();
    List<Student> findByDormIdIs(Long dormId);
}