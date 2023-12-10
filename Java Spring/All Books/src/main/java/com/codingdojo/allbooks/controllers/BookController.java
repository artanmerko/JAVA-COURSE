package com.codingdojo.allbooks.controllers;

import com.codingdojo.allbooks.models.Book;
import com.codingdojo.allbooks.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/")
    public String home() {
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String index(Model model) {

        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "index";
    }
}
