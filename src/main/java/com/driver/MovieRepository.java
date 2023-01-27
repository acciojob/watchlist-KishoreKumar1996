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

    public void  addMovieDirectorPair(String movie, String direct){
      if(directorMap.containsKey(direct) && movieMap.containsKey(movie)){
             List<String> movieDirect=new ArrayList<>();
             if(directorMovieMapping.containsKey(direct)) {
               movieDirect=directorMovieMapping.get(direct);
                 directorMovieMapping.put(direct,movieDirect);
             }
                 movieDirect.add(movie);
                 directorMovieMapping.put(direct,movieDirect);
      }
    }

    public Movie getMovieByName(String name){
      return movieMap.get(name) ;
    }
    public Director getMovieByDirector(String dir){
        return directorMap.get(dir) ;
    }

    public List<String> getMoviesByDirectorName(String name){
        List<String> listOfMovie=new ArrayList<>();
        if(directorMovieMapping.containsKey(name))
            listOfMovie= directorMovieMapping.get(name);
        return listOfMovie;
    }
    public List<String> findAllMovies(){

        return new ArrayList<>(movieMap.keySet());
    }
    public void deleteDirectorByName(String director){

        List<String> movies = new ArrayList<String>();
        if(directorMovieMapping.containsKey(director)){

            movies = directorMovieMapping.get(director);

            for(String movie: movies){
                if(movieMap.containsKey(movie)){
                    movieMap.remove(movie);
                }
            }
            directorMovieMapping.remove(director);
        }
        if(directorMap.containsKey(director)){
            directorMap.remove(director);
        }
    }
    public void deleteAllDirector(){

        HashSet<String> moviesSet = new HashSet<String>();

        directorMap = new HashMap<>();
        for(String director: directorMovieMapping.keySet()){

            for(String movie: directorMovieMapping.get(director)){
                moviesSet.add(movie);
            }
        }

        for(String movie: moviesSet){
            if(movieMap.containsKey(movie)){
                movieMap.remove(movie);
            }
        }
        directorMovieMapping = new HashMap<>();

    }
}
