package com.codingdojo.allbooks.controllers;

import com.codingdojo.allbooks.models.Book;
import com.codingdojo.allbooks.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksApi {

    private final BookService service;

    public BooksApi(BookService service) {
        this.service = service;
    }

    @RequestMapping("/api/books")
    public List<Book> index() {
        return service.allBooks();
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.POST)
    public Book create(@RequestBody Book book) {
        return service.createBook(book);
    }


    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = service.findBook(id);
        return book;
    }


    // other methods removed for brevity
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Book update(
            @PathVariable("id") Long id,
            @RequestParam(value="title") String title,
            @RequestParam(value="description") String description,
            @RequestParam(value="language") String lang,
            @RequestParam(value="pages") Integer numOfPages) {


        Book book = new Book(title, description, lang, numOfPages);
        book.setId(id);

        book = service.updateBook(book);

        return book;
    }

    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        service.deleteBook(id);
    }
}