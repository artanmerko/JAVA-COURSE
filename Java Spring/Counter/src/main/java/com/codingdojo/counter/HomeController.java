package com.codingdojo.counter;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(HttpSession session, Model model) {

        Integer count = 0;

        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        } else {
            count = (Integer) session.getAttribute("count");
            count++;
            session.setAttribute("count", count);
        }

        model.addAttribute("count", count);
        return "index";
    }

    @RequestMapping("/counter")
    public String counter(HttpSession session, Model model) {
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 0;
        }
        model.addAttribute("count", count);
        return "counter";
    }

    @RequestMapping("/increment")
    public String increment(HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
        if (count != null) {
            count += 2;
            session.setAttribute("count", count);
        }
        return "redirect:/counter";
    }

    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public String reset(HttpSession session) {
        session.setAttribute("count", 0);
        return "redirect:/counter";
    }

    @RequestMapping("/test-visit")
    public String testVisit(HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
        if (count != null) {
            count++;
            session.setAttribute("count", count);
        }
        return "redirect:/counter";
    }
}
