package com.codingdojo.studentroster1n.repositories;

import com.codingdojo.studentroster1n.models.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findAll();
    List<Student> findByDormId(Long dormId);
}
