package com.codingdojo.studentroster1n.services;

import com.codingdojo.studentroster1n.models.Student;
import com.codingdojo.studentroster1n.repositories.StudentRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> dormStudents(Long dormId) {
        return studentRepository.findByDormId(dormId);
    }


    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteFromDorm(Student student){
        student.setDorm(null);
        studentRepository.save(student);
    }

    public Student findStudent(Long id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            return optionalStudent.get();
        } else {
            return null;
        }
    }
}
