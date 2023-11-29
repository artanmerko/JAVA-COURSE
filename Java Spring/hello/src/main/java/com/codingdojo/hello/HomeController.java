package com.codingdojo.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/id")
public class HomeController {
    @RequestMapping("")
    public String index() {
        return "This is a message";
    }
    @RequestMapping("/world")
    public String world () {
        return ("Class annotation");
    }
}
