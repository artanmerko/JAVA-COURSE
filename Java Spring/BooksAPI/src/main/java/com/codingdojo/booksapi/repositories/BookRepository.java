package com.codingdojo.booksapi.repositories;

import com.codingdojo.booksapi.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository  extends CrudRepository<Book, Long> {
    List<Book> findAll();
    List<Book> findByDescriptionContaining(String search);
}