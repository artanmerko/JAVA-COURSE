package com.codingdojo.studentroster.repositories;

import com.codingdojo.studentroster.models.Course;
import com.codingdojo.studentroster.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findAll();
    List<Course> findAllByStudents(Student student);
    List<Course> findByStudentsNotContains(Student student);
}
