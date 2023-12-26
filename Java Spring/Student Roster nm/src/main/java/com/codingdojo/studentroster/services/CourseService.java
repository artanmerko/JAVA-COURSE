package com.codingdojo.studentroster.services;

import com.codingdojo.studentroster.models.Course;
import com.codingdojo.studentroster.models.Student;
import com.codingdojo.studentroster.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> allCourses() {
        return courseRepository.findAll();
    }

    public List<Course> getAssignedCourses(Student student){
        return courseRepository.findAllByStudents(student);
    }

    public List<Course> getUnassignedCourses(Student student){
        return courseRepository.findByStudentsNotContains(student);
    }

    public Course findById(Long id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if(optionalCourse.isPresent()) {
            return optionalCourse.get();
        }

        return null;
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    public void dropCourse(Course course, Student student) {
        course.getStudents().remove(student);
        courseRepository.save(course);
    }
}