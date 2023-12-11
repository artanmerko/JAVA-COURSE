package com.codingdojo.burgertracker2.repositories;

import com.codingdojo.burgertracker2.models.Burger;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BurgerRepository extends CrudRepository<Burger, Long> {
    List<Burger> findAll();
}