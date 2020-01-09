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
    public List<Category> getAllCategories();
    
     /**
     * Create a new category in the database
     * @param category
     * @return boolean
     */
    public Category createCategory(Category category);
    
    /**
     * Updates the database
     * @param category
     * @return boolean
     */
    public boolean updateCategory(Category category);
    
    /**
     * Deletes a category from the database
     * @param category
     * @return boolean
     */
    public boolean deleteCategory(Category category);
    
    /**
     * 
     * @param category
     * @return 
     */
     public List<Movie> getAllMoviesInCategory(Category category);
     
     
     public boolean addToCategory(Category category, Movie movie);
     
     
      public boolean clearCategory(Category category);
      
      
      public boolean clearMovieFromCategory(Category category, Movie movie);
}
