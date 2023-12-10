package com.codingdojo.renderingbooks.controllers;

import com.codingdojo.renderingbooks.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/")
    public String home() {
        return "redirect:/books";
    }

    @GetMapping("/books/{bookId}")
    public String index(Model model, @PathVariable("bookId") Long bookId) {

        model.addAttribute("book", bookService.findBook(bookId));
        return "show";
    }

}