package com.codingdojo.movies.controllers;

import com.codingdojo.movies.models.*;
import com.codingdojo.movies.services.MovieService;
import com.codingdojo.movies.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public String home(Model model, HttpSession session, @RequestParam(defaultValue = "0") int page) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        }

        // Define the number of items per page
        int pageSize = 10;

        // Create a Pageable object to represent the pagination information
        Pageable pageable = PageRequest.of(page, pageSize);

        // Retrieve movies using pagination
        Page<Movie> moviePage = movies.getAll(pageable);

        model.addAttribute("movies", moviePage.getContent());
        model.addAttribute("user", users.findById((Long) session.getAttribute("userId")));

        // Pass pagination information to the view
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", moviePage.getTotalPages());

        return "home";
    }

    @GetMapping("/addPage")
    public String addPage(@ModelAttribute("movie") Movie movie, Model model, HttpSession session) {
        User user = users.findById((Long)session.getAttribute("userId"));
        model.addAttribute("user", user);
        return "addPage";
    }

    @PostMapping("/movies")
    public String createMovie(@Valid @ModelAttribute("movie") Movie movie,
                              BindingResult result,
                              @RequestParam("pictureUrl") String pictureUrl,
                              @RequestParam("videoTrailerUrl") String videoTrailerUrl,
                              HttpSession session) {
        if (result.hasErrors()) {
            return "addPage";
        }

        Long userId = (Long) session.getAttribute("userId");
        User user = users.findById(userId);

        movie.setUser(user);
        movie.setPictureUrl(pictureUrl);
        movie.setVideoTrailerUrl(videoTrailerUrl);

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
        if (session.getAttribute("userId") == null) {
            return "redirect:/home";
        }
        Movie movie = movies.findById(id);
        List<Rating> ratings = movies.getRatingsForMovie(id);
        List<Note> notes = movies.getNotesForMovie(id);
        model.addAttribute("movies", movie);
        model.addAttribute("ratings", ratings);
        model.addAttribute("notes", notes);
        model.addAttribute("rating", new Rating());
        model.addAttribute("user", users.findById((Long) session.getAttribute("userId")));
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
    @PostMapping("/movies/{movieId}/note")
    public String addNote(@PathVariable("movieId") Long movieId, @RequestParam("note") String noteText, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        User user = users.findById(userId);
        Movie movie = movies.findById(movieId);

        Optional<Note> existingNote = movies.findNoteByUserAndMovie(userId, movieId);

        if (existingNote.isPresent()) {
            Note noteToUpdate = existingNote.get();
            noteToUpdate.setNote(noteText);
            movies.saveOrUpdateNote(noteToUpdate);
        } else {
            Note newNote = new Note();
            newNote.setNote(noteText);
            newNote.setUser(user);
            newNote.setMovie(movie);
            movies.saveOrUpdateNote(newNote);
        }

        return "redirect:/movies/" + movieId;
    }
    @PostMapping("/movies/{movieId}/favorite")
    public String toggleFavorite(@PathVariable("movieId") Long movieId, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        Movie movie = movies.findById(movieId);
        if (movie != null) {
            // Toggle the favorite status
            Boolean currentFavoriteStatus = movie.getFavorite() != null && movie.getFavorite();
            movie.setFavorite(!currentFavoriteStatus);
            movies.updateMovie(movie); // Save the updated movie to the database
        }

        return "redirect:/home";
    }



    @GetMapping("/favorites")
    public String viewFavorites(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        List<Movie> favoriteMovies = movies.getAllFavoriteMovies();
        model.addAttribute("favoriteMovies", favoriteMovies);

        return "favorite";
    }


}
