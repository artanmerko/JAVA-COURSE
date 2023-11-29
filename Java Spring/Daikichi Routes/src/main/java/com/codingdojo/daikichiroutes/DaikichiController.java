package com.codingdojo.daikichiroutes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
    @RequestMapping({"","/"})
    public String route1() {
        return("Welcome");
    }
    @RequestMapping("/today")
    public String route2() {
        return ("Today you will find luck in all your endeavors!");
    }
    @RequestMapping("/tomorrow")
    public String route3() {
        return ("Tomorrow, an opportunity will arise, so be sure to be open to new ideas!");
    }
}
