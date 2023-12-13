package com.codingdojo.dojoandninjas.controllers;

import com.codingdojo.dojoandninjas.models.Dojo;
import com.codingdojo.dojoandninjas.services.DojoNinjaServ;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DojoCont {
    private final DojoNinjaServ dojoNinjaServ;

    public DojoCont(DojoNinjaServ dojoNinjaServ) {
        this.dojoNinjaServ = dojoNinjaServ;
    }

    @GetMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojoObject") Dojo dojo) {
        return "newdojo";
    }

    @PostMapping("/adddojo")
    public String addDojo(@Valid @ModelAttribute("dojoObject") Dojo dojo, BindingResult result) {
        if(result.hasErrors()) {
            return "newdojo";
        }
        else {
            dojoNinjaServ.addDojo(dojo);
            return "redirect:/ninjas/new";
        }
    }

    @GetMapping("/dojos/{dojoId}")
    public String showDojo(@PathVariable("dojoId") long id, Model model) {
        Dojo dojo = dojoNinjaServ.singleDojo(id);
        model.addAttribute("dojo", dojo);
        return "show";
    }


}