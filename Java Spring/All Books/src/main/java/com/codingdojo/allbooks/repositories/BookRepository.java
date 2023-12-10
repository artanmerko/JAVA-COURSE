package com.codingdojo.allbooks.repositories;

import com.codingdojo.allbooks.models.Book;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();
}