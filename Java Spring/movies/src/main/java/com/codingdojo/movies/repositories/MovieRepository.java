package com.codingdojo.movies.repositories;

import com.codingdojo.movies.models.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    List<Movie> findAll();
    Optional<Movie> findByTitle(String title);
    Optional<Movie> findById(Long id);

    Page<Movie> findAll(Pageable pageable);
    @Query("SELECT m FROM Movie m WHERE m.favorite = true")
    List<Movie> findFavoriteMoviesByAnyUser();

}
