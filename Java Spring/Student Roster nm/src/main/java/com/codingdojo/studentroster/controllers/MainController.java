package com.codingdojo.studentroster.controllers;

import com.codingdojo.studentroster.models.Course;
import com.codingdojo.studentroster.models.Dorm;
import com.codingdojo.studentroster.models.Student;
import com.codingdojo.studentroster.services.CourseService;
import com.codingdojo.studentroster.services.DormService;
import com.codingdojo.studentroster.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    private DormService dormService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("dorms", dormService.allDorms());
        return "dorms.jsp";
    }

//	*** Student Roster n:m ***

    @Autowired
    private CourseService courseService;

    @GetMapping("/classes")
    public String viewClasses(Model model) {
        model.addAttribute("courses", courseService.allCourses());
        return "viewClasses.jsp";
    }

    @GetMapping("/classes/new")
    public String newClass(@ModelAttribute("course") Course course) {
        return "newClass.jsp";
    }

    @PostMapping("/classes/new")
    public String addClass(@ModelAttribute("course") Course course) {
        courseService.addCourse(course);
        return "redirect:/classes";
    }

    @GetMapping("/classes/{id}")
    public String viewClass(@PathVariable("id") Long id, Model model) {
        model.addAttribute("course", courseService.findById(id));
        return "viewClass.jsp";
    }

    @GetMapping("/students/{studentId}")
    public String viewStudent(@PathVariable("studentId") Long studentId, Model model) {
        Student student = studentService.findStudent(studentId);
        model.addAttribute("student", student);
        model.addAttribute("availableCourses", courseService.getUnassignedCourses(student));
        model.addAttribute("assignedCourses", courseService.getAssignedCourses(student));
        return "viewStudent.jsp";
    }

    @PostMapping("/students/{studentId}/add-class")
    public String assignCourse(@PathVariable("studentId") Long studentId, @RequestParam("courseId") Long courseId) {
        Student student = studentService.findStudent(studentId);
        Course course = courseService.findById(courseId);
        course.getStudents().add(student);
        courseService.updateCourse(course);
        return "redirect:/students/"+studentId;
    }

    @GetMapping("/students/{studentId}/classes/{courseId}/drop")
    public String dropCourse(@PathVariable("studentId") Long studentId, @PathVariable("courseId") Long courseId) {
        Student student = studentService.findStudent(studentId);
        Course course = courseService.findById(courseId);
        courseService.dropCourse(course, student);
        return "redirect:/students/"+studentId;
    }


//	*** Student Roster 1:m ***

    @GetMapping("/dorms/new")
    public String newDorm(@ModelAttribute("dorm") Dorm dorm) {
        return "newDorm.jsp";
    }

    @PostMapping("/dorms/new")
    public String addDorm(@ModelAttribute("dorm") Dorm dorm) {
        dormService.addDorm(dorm);
        return "redirect:/";
    }

    @GetMapping("/students/new")
    public String newStudent(@ModelAttribute("student") Student student, Model model) {
        model.addAttribute("dorms", dormService.allDorms());
        return "newStudent.jsp";
    }

    @PostMapping("/students/new")
    public String addStudent(@ModelAttribute("student") Student student) {
        studentService.addStudent(student);
        return "redirect:/";
    }

    @GetMapping("/dorms/{id}")
    public String viewDorms(@PathVariable("id") Long id, Model model) {
        model.addAttribute("dorm", dormService.findDorm(id));
        model.addAttribute("students", studentService.dormStudents(id));
        return "viewDorm.jsp";
    }

    @GetMapping("/students/remove/{id}")
    public String removeStudent(@PathVariable("id") Long id) {
        studentService.removeFromDorm(studentService.findStudent(id));
        return "redirect:/";
    }
}