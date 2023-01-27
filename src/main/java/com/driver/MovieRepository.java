package com.driver;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
@Repository
public class MovieRepository {

    HashMap<String, Movie> movieDb = new HashMap<>();
    HashMap<String, Director> directorDb = new HashMap<>();
    HashMap<String, List<String>> movieDirectorDb = new HashMap<>();

    public String addMovie(Movie movie) {
        movieDb.put(movie.getName(), movie);
        return "success";
    }

    public String addDirector(Director director) {
        directorDb.put(director.getName(), director);
        return "success";
    }

    public String addMovieDirectorPair(String movieName, String directorName) {
        if (!movieDirectorDb.containsKey(directorName)) {
            movieDirectorDb.put(directorName, new ArrayList<String>());
        }
        movieDirectorDb.get(directorName).add(movieName);
        return "success";
    }

    public Movie getMovieByName(String name) {
        return movieDb.get(name);
    }

    public Director getDirectorByName(String name) {
        return directorDb.get(name);
    }

    public List<String> getMoviesByDirector(String name) {
        return movieDirectorDb.get(name);
    }

    public List<String> getallMovies() {
        return new ArrayList<>(movieDb.keySet());
    }

    public String deleteDirectorByName(String name) {
        directorDb.remove(name);
        for (String m : movieDirectorDb.get(name)) {
            movieDb.remove(m);
        }
        movieDirectorDb.remove(name);
        return "success";
    }

    public String deleteAllDirectorandMovies() {
        for (String name : directorDb.keySet()) {
            if (movieDirectorDb.containsKey(name)) {
                for (String m : movieDirectorDb.get(name)) {
                    movieDb.remove(m);
                }
                movieDirectorDb.remove(name);
            }
            directorDb.remove(name);
        }
        return "success";
    }
}