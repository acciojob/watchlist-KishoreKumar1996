package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepo;

    public String addMovie(Movie movie) {
        return movieRepo.addMovie(movie);
    }

    public String addDirector(Director director) {
        return movieRepo.addDirector(director);
    }

    public String addMovieDirector(String movieName, String directorName) {
        return movieRepo.addMovieDirectorPair(movieName, directorName);
    }

    public Movie getMovieByName(String name) {
        return movieRepo.getMovieByName(name);
    }

    public Director directorByName(String name) {
        return movieRepo.getDirectorByName(name);
    }

    public List<String> getMoviesByDirector(String name) {
        return movieRepo.getMoviesByDirector(name);
    }

    public List<String> getAllMovies() {
        return movieRepo.getallMovies();
    }

    public String deleteDirectorByName(String name) {
        return movieRepo.deleteDirectorByName(name);
    }

    public String deleteAllDirectors() {
        return movieRepo.deleteAllDirectorandMovies();
    }
}
