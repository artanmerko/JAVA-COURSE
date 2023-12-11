package com.codingdojo.burgertracker2.services;

import com.codingdojo.burgertracker2.models.Burger;
import com.codingdojo.burgertracker2.repositories.BurgerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BurgerService {
    private final BurgerRepository burgerRepo;

    public BurgerService(BurgerRepository burgerRepo) {
        this.burgerRepo = burgerRepo;
    }

    public List<Burger> allBurgers() {
        return burgerRepo.findAll();
    }

    public Burger addBurger(Burger burger) {
        return burgerRepo.save(burger);
    }

    public Burger findBurger(Long id) {
        Optional<Burger> burger = burgerRepo.findById(id);
        if (burger.isPresent()) {
            return burger.get();
        }
        else {
            return null;
        }
    }

    public Burger updateBurger(Burger burger) {
        return burgerRepo.save(burger);
    }

    public void deleteBurger(Long id) {
        burgerRepo.deleteById(id);
    }


}