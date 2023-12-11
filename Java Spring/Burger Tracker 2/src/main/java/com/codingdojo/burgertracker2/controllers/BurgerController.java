package com.codingdojo.burgertracker2.controllers;

import com.codingdojo.burgertracker2.models.Burger;
import com.codingdojo.burgertracker2.services.BurgerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BurgerController {
    @Autowired
    BurgerService burgerService;

    @GetMapping("/")
    public String home(@ModelAttribute("burger") Burger burger, Model model) {
        List<Burger> burgers = burgerService.allBurgers();
        model.addAttribute("burgers", burgers);
        return "index";
    }

    @PostMapping("/addBurger")
    public String home(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Burger> burgers = burgerService.allBurgers();
            model.addAttribute("burgers", burgers);
            return "index";
        }
        burgerService.addBurger(burger);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editBurger(@PathVariable("id") Long id, @ModelAttribute("burger") Burger burger, Model model) {
        model.addAttribute("burger", burgerService.findBurger(id));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String updateBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, @PathVariable("id") Long id, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("burger", burger);
            return "index";
        }
        burgerService.updateBurger(burger);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
        burgerService.deleteBurger(id);
        return "redirect:/";
    }


}