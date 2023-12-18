package com.codingdojo.bookbroker.services;

import com.codingdojo.bookbroker.models.Book;
import com.codingdojo.bookbroker.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book findById(Long id){
        Optional<Book> result = bookRepository.findById(id);
        if(result.isPresent()){
          return result.get();
        }
        return null;
    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public Book updateBook(Book book){ return bookRepository.save(book); }
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

}

