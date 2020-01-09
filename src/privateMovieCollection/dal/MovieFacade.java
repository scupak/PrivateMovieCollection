/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.dal;

import java.util.List;
import privateMovieCollection.be.Category;
import privateMovieCollection.be.Movie;

/**
 *
 * @author andreasvillumsen
 */
public interface MovieFacade {
    /**
     * List over all movies in database
     * @return list of movies
     */
    public List<Movie> getAllMovies();
    
     /**
     * Create a new movie in the database
     * @param movie
     * @return boolean
     */
    public Movie createMovie(Movie movie);
    
    /**
     * Updates the database
     * @param movie
     * @return boolean
     */
    public boolean updateMovie(Movie movie);
    
    /**
     * Deletes a movie from the database
     * @param movie
     * @return boolean
     */
   public boolean deleteMovie(Movie movie);
   
   /**
    * 
    * @param movie
    * @return 
    */
    public List<Category>GetAllCategoriesWithMovie(Movie movie);
}
