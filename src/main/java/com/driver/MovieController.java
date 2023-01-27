package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService service;
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
            return new ResponseEntity<>("Successfully added the movie name", HttpStatus.CREATED);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director direct) {
         if(service.addDirector(direct).equals("Successfully added the director name")){
             return new ResponseEntity<>(service.addDirector(direct),HttpStatus.CREATED);
         }
         return new ResponseEntity<>("Not Inserted, make sure the required field",HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String>  addMovieDirectorPair(@RequestParam("movie") String movie,@RequestParam("dir") String direct){
         service.addMovieDirectorPair(movie,direct);
         return new ResponseEntity<>("Added movie-director pair",HttpStatus.CREATED);
    }
    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable() String name){
       Movie movie= service.getMovieByName(name);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Movie> getDirectorByName(@PathVariable() String name){
        Movie movie= service.getMovieByName(name);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }
    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>>getMoviesByDirectorName(@PathVariable() String director){
        List<String> listmovie= service.getMoviesByDirectorName(director);
        return new ResponseEntity<>(listmovie,HttpStatus.CREATED);
    }
    @GetMapping("/movies/get-all-movie")
    public ResponseEntity<List<String>> findAllMovies(){

        return new ResponseEntity<>(service.findAllMovies(),HttpStatus.CREATED);
    }
    @DeleteMapping ("/movies/delete-director-by-name")
    public ResponseEntity<String>  deleteDirectorByName(@RequestParam("dir") String director){
         String message=service.deleteDirectorByName(director);
        return new ResponseEntity<>(message+"successfully remove director by name",HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        String message=service.deleteAllDirectors();
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

}
