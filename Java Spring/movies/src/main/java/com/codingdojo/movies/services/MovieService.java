package com.codingdojo.movies.services;

import com.codingdojo.movies.models.Movie;
import com.codingdojo.movies.models.Note;
import com.codingdojo.movies.models.Rating;
import com.codingdojo.movies.repositories.MovieRepository;
import com.codingdojo.movies.repositories.NoteRepository;
import com.codingdojo.movies.repositories.RatingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private NoteRepository noteRepository;

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

    @Transactional
    public void deleteMovie(Long id){
        Optional<Movie> optionalMovie = movieRepository.findById(id);

        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();

            // Delete Ratings
            List<Rating> ratings = ratingRepository.findByMovieIdOrderByScoreDesc(id);
            for (Rating rating : ratings) {
                ratingRepository.delete(rating);
            }

            // Delete Notes
            List<Note> notes = noteRepository.findByMovieIdOrderByNoteDesc(id);
            for (Note note : notes) {
                noteRepository.delete(note);
            }

            // Delete the Movie
            movieRepository.delete(movie);
        }
    }


    public List<Rating> getRatingsForMovie(Long movieId) {
        List<Rating> ratings = ratingRepository.findByMovieIdOrderByScoreDesc(movieId);
        return ratings;
    }

    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Optional<Rating> findRatingByUserAndMovie(Long userId, Long movieId) {
        return ratingRepository.findByUserIdAndMovieId(userId, movieId);
    }
    public Optional<Note> findNoteByUserAndMovie(Long userId, Long movieId) {
        return noteRepository.findByUserIdAndMovieId(userId, movieId);
    }

    public Note saveOrUpdateNote(Note note) {
        return noteRepository.save(note);
    }


    public List<Note> getNotesForMovie(Long movieId) {
        List<Note> notes = noteRepository.findByMovieIdOrderByNoteDesc(movieId);
        return notes;
    }

    public Page<Movie> getAll(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    public List<Movie> getAllFavoriteMovies() {
        return movieRepository.findFavoriteMoviesByAnyUser();
    }


}
