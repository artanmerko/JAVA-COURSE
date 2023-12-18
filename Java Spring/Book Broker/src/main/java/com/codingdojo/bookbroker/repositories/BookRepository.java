package com.codingdojo.bookbroker.repositories;

import com.codingdojo.bookbroker.models.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();
}
