package com.codingdojo.burgertracker1.repositories;

import com.codingdojo.burgertracker1.models.Burger;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BurgerRepository extends CrudRepository<Burger, Long> {
    List<Burger> findAll();
}
