package com.codingdojo.daikichiroutes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DaikichiRoutesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaikichiRoutesApplication.class, args);
    }
    @RequestMapping("/")
    public String home() {
        return ("Java Spring");
    }

}
