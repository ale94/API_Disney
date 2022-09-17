package com.domain.alkemy.service;

import com.domain.alkemy.models.Character;
import com.domain.alkemy.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IMovieService {
    public List<Movie> getAllMovies();
    public Movie getMovie(Long id);
    public void addMovie(Movie movie);
    public void editMovie(Movie movie, Long id);
    public void deleteMovie(Long id);
    public List<Movie> findByTitle(String title);

    public List<Movie> orderDate(String order);
}
