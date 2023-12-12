package com.codingdojo.savetravels.controllers;

import com.codingdojo.savetravels.models.Travel;
import com.codingdojo.savetravels.services.TravelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    TravelService travelService;

    @GetMapping("/")
    public String home(@ModelAttribute("travel")Travel travel, Model model){
        List<Travel> travels = travelService.allTravels();
        model.addAttribute("travels", travels);
        return "index";
    }
    @PostMapping("/addTravel")
    public String home(@Valid @ModelAttribute("travel")Travel travel, BindingResult result, Model model){
        if(result.hasErrors()){
            List<Travel> travels = travelService.allTravels();
            model.addAttribute("travels", travels);
            return "index";
        } else {
            travelService.addTravel(travel);
            return "redirect:/";
        }
    }

    @GetMapping("/edit/{id}")
    public String editTravel(@PathVariable("id") Long id, @ModelAttribute("travel") Travel travel, Model model){
        model.addAttribute("travel", travelService.findTravel(id));
        return "edit";
    }
    @PostMapping("/edit/{id}")
    public String updateTravel(@Valid @ModelAttribute("travel")Travel travel, BindingResult result, @PathVariable("id") Long id, Model model){
        if(result.hasErrors()){
            model.addAttribute("travel", travel);
            return "index";
        } else {
            travelService.updateTravel(travel);
            return "redirect:/";
        }
    }
    @DeleteMapping("/delete/{id}")
    public String destroy (@PathVariable("id") Long id){
        travelService.deleteTravel(id);
        return "redirect:/";
    }
}
