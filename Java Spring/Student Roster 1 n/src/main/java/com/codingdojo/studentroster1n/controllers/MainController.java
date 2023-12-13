package com.codingdojo.studentroster1n.controllers;

import com.codingdojo.studentroster1n.models.Dorm;
import com.codingdojo.studentroster1n.models.Student;
import com.codingdojo.studentroster1n.services.DormService;
import com.codingdojo.studentroster1n.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @Autowired
    private DormService dormService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("dorms", dormService.getAllDorms());
        return"dorms";
    }

    @GetMapping("/dorms/new")
    public String newDorm(@ModelAttribute("dorm") Dorm dorm) {
        return "newDorm";
    }

    @PostMapping("/dorms/new")
    public String addDorm(@ModelAttribute("dorm") @Valid Dorm dorm, BindingResult result) {
        if (result.hasErrors()) {
            return "newDorm";
        }
        dormService.addDorm(dorm);
        return "redirect:/";
    }

    @GetMapping("/students/new")
    public String newStudent(@ModelAttribute("student")Student student, Model model){
        model.addAttribute("dorms", dormService.getAllDorms());
        return "newStudent";
    }

    @PostMapping("/students/new")
    public String addStudent(@Valid @ModelAttribute("student")Student student, BindingResult result){
        if(result.hasErrors()){
            return "newStudent";
        }
        studentService.addStudent(student);
        return "redirect:/";
    }

    @GetMapping("/dorms/{id}")
    public String viewDorms(@PathVariable("id") Long id, Model model){
        model.addAttribute("dorm", dormService.findDorm(id));
        model.addAttribute("students", studentService.dormStudents(id));
        return "viewDorm";
    }

    @GetMapping("/students/remove/{id}")
    public String deleteStudent(@PathVariable("id")Long id){
        studentService.deleteFromDorm(studentService.findStudent(id));
        return "redirect:/";
    }
}
