package com.codingdojo.movies.repositories;

import com.codingdojo.movies.models.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
    List<Note> findByMovieIdOrderByNoteDesc(Long movieId);
    Optional<Note> findByUserIdAndMovieId(Long userId, Long movieId);

}
