/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.bll;

import java.util.List;
import privateMovieCollection.be.Category;
import privateMovieCollection.be.Movie;
import privateMovieCollection.dal.CategoryFacade;
import privateMovieCollection.dal.database.CategoryDBDAO;

/**
 *
 * @author anton
 */
public class CategoryManager {
    
    private CategoryFacade CategoryDBDAO;
    
    /**
     * Category Manager Constructor
     */
    public CategoryManager(){
        CategoryDBDAO = new CategoryDBDAO();
    }
    
    /**
     * Get a list of categories
     * 
     * @return categories
     */
    public List<Category> getAllCategories(){
        List<Category> categories = CategoryDBDAO.getAllCategories();
        
        for (Category category : categories) {
            category.setMovies(CategoryDBDAO.getAllMoviesInCategory(category).size());
        }
                
        return categories;
    }
    
    /**
     * Create a category
     * 
     * @param category
     */
    public void createCategory(Category category){
        CategoryDBDAO.createCategory(category);
    }
    
    /**
     * Delete a category
     * 
     * @param category 
     */
    public void deleteCategory(Category category){
        CategoryDBDAO.deleteCategory(category);
    }
    
    /**
     * Update a category
     * 
     * @param category 
     */
    public void updateCategory(Category category)   {
        CategoryDBDAO.updateCategory(category);
    }
    
    /**
     * Get all movies in a category
     * 
     * @param category
     * @return movies
     */
    public List<Movie> getAllMoviesinCategory(Category category){
        return CategoryDBDAO.getAllMoviesInCategory(category);
    
    }
    /**
     * Add a movie to a category
     * 
     * @param category
     * @param movie 
     */
    public void addToCategory(Category category, Movie movie){
        CategoryDBDAO.addToCategory(category, movie);
    }
    
    /**
     * Clear all movies from a category
     * 
     * @param category 
     */
    public void clearCategory(Category category){
        CategoryDBDAO.clearCategory(category);
    }
    
    /**
     * Remove a movie from a category
     * 
     * @param category
     * @param movie
     * @return 
     */
    public boolean clearMovieFromPlayList(Category category, Movie movie){
        return CategoryDBDAO.clearMovieFromCategory(category, movie);
    }
    
}
