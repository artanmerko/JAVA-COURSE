package com.codingdojo.renderingbooks.repositories;

import com.codingdojo.renderingbooks.models.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findAll();

}