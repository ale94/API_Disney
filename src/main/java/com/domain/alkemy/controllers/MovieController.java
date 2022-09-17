package com.domain.alkemy.controllers;

import com.domain.alkemy.models.Movie;
import com.domain.alkemy.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable Long id) {
        return movieService.getMovie(id);
    }

    @GetMapping(value = "/movies", params = "title")
    public List<Movie> findByTitle(@RequestParam String title) {
        return movieService.findByTitle(title);
    }

    @GetMapping(value = "/movies", params = "order")
    public List<Movie> orderDate(@RequestParam String order) {
        return movieService.orderDate(order);
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return movie;
    }

    @PutMapping("/movies/{id}")
    public Movie editMovie(@RequestBody Movie movie, @PathVariable Long id) {
        movieService.editMovie(movie, id);
        return movie;
    }

    @DeleteMapping("/movies/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return "Personaje borrado con exito";
    }
}
