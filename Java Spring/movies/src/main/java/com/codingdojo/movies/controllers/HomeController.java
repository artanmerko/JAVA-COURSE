package com.codingdojo.movies.controllers;

import com.codingdojo.movies.models.LoginUser;
import com.codingdojo.movies.models.Movie;
import com.codingdojo.movies.models.Rating;
import com.codingdojo.movies.models.User;
import com.codingdojo.movies.services.MovieService;
import com.codingdojo.movies.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private UserService users;

    @Autowired
    private MovieService movies;

    @GetMapping("/")
    public String index(Model model, @ModelAttribute("newUser") User newUser,
                        @ModelAttribute("newLogin") User newLogin, HttpSession session) {
        if(session.getAttribute("userId") != null) {
            return "redirect:/home";
        }
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {

        User user = users.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index";
        }
        session.setAttribute("userId", user.getId());
        return "redirect:/home";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {

        User user = users.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index";
        }
        session.setAttribute("userId", user.getId());
        return "redirect:/home";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        if(session.getAttribute("userId") == null) {
            return "redirect:/";
        }
        model.addAttribute("movies", movies.getAll());
        model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
        return "home";
    }

    @GetMapping("/addPage")
    public String addPage(@ModelAttribute("movie") Movie movie, Model model, HttpSession session) {
        User user = users.findById((Long)session.getAttribute("userId"));
        model.addAttribute("user", user);
        return "addPage";
    }

    @PostMapping("/movies")
    public String createMovie(@Valid @ModelAttribute("movie") Movie movie, BindingResult result) {
        if (result.hasErrors()) {
            return "addPage";
        }
        try {
            movies.createMovie(movie);
        } catch (IllegalArgumentException e) {
            result.rejectValue("title", "error.movie", "A movie with this title already exists.");
            return "addPage";
        }

        return "redirect:/home";
    }

    @GetMapping("/movies/{id}")
    public String movieDetail(Model model, @PathVariable("id") Long id, HttpSession session) {
        if(session.getAttribute("userId") == null) {
            return "redirect:/home";
        }
        Movie movie = movies.findById(id);
        List<Rating> ratings = movies.getRatingsForMovie(id);
        model.addAttribute("movies", movie);
        model.addAttribute("ratings", ratings);
        model.addAttribute("rating", new Rating());
        model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
        return "movie";
    }


    @GetMapping("/movies/{id}/edit")
    public String getEditMovie(@PathVariable("id") Long id, Model model,HttpSession session){
        if(session.getAttribute("userId") == null) {
            return "redirect:/home";
        }
        Movie movieEdit = movies.findById(id);
        model.addAttribute("movieEdit",movieEdit);
        return "editMovie";
    }

    @PutMapping("/movies/{id}/update")
    public String editMovie(@Valid @ModelAttribute("movieEdit") Movie movieEdit, BindingResult result, Model model, @PathVariable("id") Long id, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        User userLogged = users.findById(userId);
        if (result.hasErrors()) {
            return "editMovie";
        } else {
            movieEdit.setUser(userLogged);
            try {
                movies.updateMovie(movieEdit);
            } catch (IllegalArgumentException e) {
                result.rejectValue("title", "error.movie", "A movie with this title already exists.");
                return "editMovie";
            }
            return "redirect:/home";
        }
    }

    @DeleteMapping("/movies/{id}/delete")
    public String deleteMovie(@PathVariable("id") Long id, HttpSession session) {
        movies.deleteMovie(id);
        return "redirect:/home";
    }

    @PostMapping("/movies/{movieId}/rate")
    public String rateMovie(@PathVariable("movieId") Long movieId, @RequestParam("score") Double score, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        Optional<Rating> existingRating = movies.findRatingByUserAndMovie(userId, movieId);
        Rating rating;
        if (existingRating.isPresent()) {
            rating = existingRating.get();
            rating.setScore(score);
        } else {
            rating = new Rating();
            rating.setUser(users.findById(userId));
            rating.setMovie(movies.findById(movieId));
            rating.setScore(score);
        }
        movies.saveRating(rating);
        return "redirect:/movies/" + movieId;
    }


}
