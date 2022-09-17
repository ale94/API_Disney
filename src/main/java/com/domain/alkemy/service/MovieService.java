package com.domain.alkemy.service;

import com.domain.alkemy.models.Character;
import com.domain.alkemy.models.Movie;
import com.domain.alkemy.repository.CharacterRepository;
import com.domain.alkemy.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService implements IMovieService{

    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovie(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void editMovie(Movie movie, Long id) {
        Movie newMovie = getMovie(id);
        newMovie.setImagen(movie.getImagen());
        newMovie.setTitulo(movie.getTitulo());
        newMovie.setFechaDeCreacion(movie.getFechaDeCreacion());
        newMovie.setCalificacion(movie.getCalificacion());
        movieRepository.save(newMovie);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<Movie> findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    @Override
    public List<Movie> orderDate(String order) {
        List<Movie> newMovies = new ArrayList<>();
        if (order.equals("ASC")) {
            newMovies =  movieRepository.orderDateAsc();
        } else if (order.equals("DESC")){
            newMovies =  movieRepository.orderDateDesc();
        }
        return newMovies;
    }
}
