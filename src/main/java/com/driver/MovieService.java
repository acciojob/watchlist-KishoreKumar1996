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
    MovieRepository repo;

    public String addMove(Movie movie){
        return repo.addMovie(movie);
    }
    public String addDirector(Director direct) {
        return repo.addDirector(direct);
    }

    public void  addMovieDirectorPair(String movie, String direct){
        repo.addMovieDirectorPair(movie,direct);
    }
    public Movie getMovieByName(String name){
        return repo.getMovieByName(name);
    }
    public Director getMovieByDirector(String dir){
        return repo.getMovieByDirector(dir) ;
    }

    public List<String> getMoviesByDirectorName(String name){
        return repo.getMoviesByDirectorName(name);
    }
    public List<String> findAllMovies(){

        return repo.findAllMovies();
    }

     public String  deleteDirectorByName(String director){

        return repo.deleteDirectorByName(director);
    }

    public String deleteAllDirectors(){
        return repo.deleteAllDirectors();
    }
}
