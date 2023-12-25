package com.codingdojo.movies.repositories;

import com.codingdojo.movies.models.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {
    List<Rating> findByMovieIdOrderByScoreDesc(Long movieId);
    Optional<Rating> findByUserIdAndMovieId(Long userId, Long movieId);

}
