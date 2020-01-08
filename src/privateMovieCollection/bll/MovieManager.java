/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.bll;

import java.util.ArrayList;
import java.util.List;
import privateMovieCollection.be.Category;
import privateMovieCollection.be.Movie;
import privateMovieCollection.dal.MovieFacade;
import privateMovieCollection.dal.database.MovieDBDAO;

/**
 *
 * @author anton
 */
public class MovieManager {
    
    private MovieFacade movieDBDAO;

    /**
     * 
     */
    public MovieManager() {
        movieDBDAO = new MovieDBDAO();
    }
    /**
     * 
     * @return 
     */
    public List<Movie>getAllMovies(){
        return movieDBDAO.getAllMovies();
    }
    /**
     * 
     * @param query
     * @return 
     */
    public List<Movie> search(ArrayList<String> query){
    
        return null;
    }
    /**
     * 
     * @param movieToAdd 
     */
    public void createMovie(Movie movieToAdd){
        movieDBDAO.createMovie(movieToAdd);
    }
    /**
     * 
     * @param movieToDelete 
     */
    public void deleteMovie(Movie movieToDelete){
        movieDBDAO.deleteMovie(movieToDelete);
    }
    
    public void updateMovie(Movie MovieToUpdate) {
        movieDBDAO.updateMovie(MovieToUpdate);
        
    }
    
    
    
    
    
}
