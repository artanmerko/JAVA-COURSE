package com.codingdojo.movies.services;

import com.codingdojo.movies.models.Movie;
import com.codingdojo.movies.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Movie findById(Long id){
        Optional<Movie> result = movieRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        return null;
    }

    public List<Movie> getAll(){
        return movieRepository.findAll();
    }

    public Movie createMovie(Movie movie){
        Optional<Movie> existingMovie = movieRepository.findByTitle(movie.getTitle());
        if (existingMovie.isPresent()) {
            throw new IllegalArgumentException("Movie with the same title already exists");
        }
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Movie movie) {
        Optional<Movie> existingMovie = movieRepository.findByTitle(movie.getTitle());
        if (existingMovie.isPresent() && !existingMovie.get().getId().equals(movie.getId())) {
            throw new IllegalArgumentException("Movie with the same title already exists");
        }
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id){
        movieRepository.deleteById(id);
    }
}
