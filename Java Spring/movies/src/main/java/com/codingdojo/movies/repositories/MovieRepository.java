package com.codingdojo.movies.repositories;

import com.codingdojo.movies.models.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    List<Movie> findAll();
    Optional<Movie> findByTitle(String title);

}
