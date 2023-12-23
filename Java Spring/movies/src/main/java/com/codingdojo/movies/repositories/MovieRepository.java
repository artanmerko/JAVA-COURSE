package com.codingdojo.movies.repositories;

import com.codingdojo.movies.models.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    List<Movie> findAll();

}
