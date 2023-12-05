package com.codingdojo.ninjagoldgame.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@Controller
@RequestMapping("/gold")
@SessionAttributes("gold")
public class HomeController {

    private final Random random = new Random();

    @RequestMapping("")
    public String index(HttpSession session) {
        session.setAttribute("gold", 0);
        session.setAttribute("activities", new ArrayList<String>());
        return "redirect:/gold/game";
    }

    @RequestMapping("/game")
    public String game() {
        return "game";
    }

    @PostMapping("/find")
    public String findGold(HttpSession session, @RequestParam("building") String building) {
        int gold = (int) session.getAttribute("gold");
        ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
        int goldFound = 0;
        String activity;
        Date date = new Date();

        switch (building) {
            case "farm":
                goldFound = random.nextInt(11) + 10;
                break;
            case "cave":
                goldFound = random.nextInt(6) + 5;
                break;
            case "house":
                goldFound = random.nextInt(4) + 2;
                break;
            case "quest":
                goldFound = random.nextInt(101) - 50;
                break;
            case "spa": // Ninja Bonus 1
                goldFound = -(random.nextInt(16) + 5);
                break;
        }

        if (goldFound >= 0) {
            activity = "You entered a " + building + " and earned " + goldFound + " gold. (" + date + ")";
        } else {
            activity = "You entered a " + building + " and lost " + Math.abs(goldFound) + " gold. Ouch. (" + date + ")";
        }

        // Update
        session.setAttribute("gold", gold + goldFound);
        activities.add(activity);
        session.setAttribute("activities", activities);

        // check
        if ((int) session.getAttribute("gold") < -50) {
            return "redirect:/gold/debtorsPrison";
        }

        return "redirect:/gold/game";
    }

    // debtors' prison page.
    @RequestMapping("/debtorsPrison")
    public String debtorsPrison(HttpSession session) {
        return "debtorsPrison";
    }

    //reset
    @PostMapping("/reset")
    public String reset(SessionStatus status) {
        status.setComplete();
        return "redirect:/gold";
    }

}