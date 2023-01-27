package com.driver;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
@Repository
public class MovieRepository {
    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMovieMapping;

    public MovieRepository(HashMap<String, Movie> movieMap, HashMap<String, Director> directorMap, HashMap<String, List<String>> directorMovieMapping) {
        this.movieMap = movieMap;
        this.directorMap = directorMap;
        this.directorMovieMapping = directorMovieMapping;
    }

    public String addMovie(Movie movie){
      movieMap.put(movie.getName(),movie);
      return "Successfully added the movie name";
    }

    public String addDirector(Director direct){
        directorMap.put(direct.getName(),direct);
        return "Successfully added the director name";
    }

    public String  addMovieDirectorPair(String movie, String direct){
        if (!directorMovieMapping.containsKey(direct)) {
            directorMovieMapping.put(direct, new ArrayList<String>());
        }
        directorMovieMapping.get(direct).add(movie);
        return "success";
    }

    public Movie getMovieByName(String name){
      return movieMap.get(name) ;
    }
    public Director getMovieByDirector(String dir){
        return directorMap.get(dir) ;
    }

    public List<String> getMoviesByDirectorName(String name){
        return directorMovieMapping.get(name);
    }
    public List<String> findAllMovies(){

        return new ArrayList<>(movieMap.keySet());
    }
    public String deleteDirectorByName(String name){

        directorMap.remove(name);
        for (String m : directorMovieMapping.get(name)) {
            movieMap.remove(m);
        }
        directorMovieMapping.remove(name);
        return "success";
    }
    public String  deleteAllDirectors() {
        for (String name : directorMap.keySet()) {
            if (directorMovieMapping.containsKey(name)) {
                for (String m : directorMovieMapping.get(name)) {
                    movieMap.remove(m);
                }
                directorMovieMapping.remove(name);
            }
            directorMap.remove(name);
        }
        return "success";
    }
}
