package com.codingdojo.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String greetings(
            @RequestParam(value="name", required = false) String name,
            @RequestParam(value="last_name", required = false) String lastName,
            @RequestParam(value="times", required = false) Integer times) {

        String greeting = "Hello ";

        if(name == null || name.isEmpty()) {
            greeting += "human";
        } else {
            greeting += name;
            if (lastName != null && !lastName.isEmpty()) {
                greeting += " " + lastName;
            }
        }

        if (times == null || times < 1) {
            times = 1;
        }

        return greeting.repeat(times);
    }
}
