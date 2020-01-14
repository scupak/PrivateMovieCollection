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
public interface CategoryFacade {
    /**
     * List over all categories in database
     * @return list of categories
     */
    public List<Category> getAllCategories() throws PmcDalException;
    
     /**
     * Create a new category in the database
     * @param category
     * @return boolean
     */
    public Category createCategory(Category category) throws PmcDalException;
    
    /**
     * Updates the database
     * @param category
     * @return boolean
     */
    public boolean updateCategory(Category category) throws PmcDalException;
    
    /**
     * Deletes a category from the database
     * @param category
     * @return boolean
     */
    public boolean deleteCategory(Category category) throws PmcDalException;
    
    /**
     * 
     * @param category
     * @return 
     */
     public List<Movie> getAllMoviesInCategory(Category category) throws PmcDalException;
     
     /**
      * 
      * @param category
      * @param movie
      * @return 
      */
     public boolean addToCategory(Category category, Movie movie) throws PmcDalException;
     
     /**
      * 
      * @param category
      * @return 
      */
      public boolean clearCategory(Category category) throws PmcDalException;
      
      /**
       * 
       * @param category
       * @param movie
       * @return 
       */
      public boolean clearMovieFromCategory(Category category, Movie movie) throws PmcDalException;
}
