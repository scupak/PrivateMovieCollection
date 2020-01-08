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
     * 
     */
    public CategoryManager(){
        CategoryDBDAO = new CategoryDBDAO();
    }
    /**
     * 
     * @return 
     */
    public List<Category> getAllCategories(){
        List<Category> result = CategoryDBDAO.getAllCategories();
        
        for (Category category : result) {
            
            category.setMovies(CategoryDBDAO.getAllMoviesInCategory(category).size());
            
        }
                
        return result;
    }
    /**
     * 
     * @param categoryToAdd
     */
    public void createCategory(Category categoryToAdd){
        CategoryDBDAO.createCategory(categoryToAdd);
    
    }
    /**
     * 
     * @param categoryToDelete 
     */
    public void deleteCategory(Category categoryToDelete){
        CategoryDBDAO.deleteCategory(categoryToDelete);
    
    }
    /**
     * 
     * @param categoryToUpdate 
     */
    public void updateCategory(Category categoryToUpdate)   {
        CategoryDBDAO.updateCategory(categoryToUpdate);
    
    }
    /**
     * 
     * @param category
     * @return 
     */
    public List<Movie> getAllMoviesinCategory(Category category){
        return CategoryDBDAO.getAllMoviesInCategory(category);
    
    }
    /**
     * 
     * @param category
     * @param movie 
     */
    public void addToCategory(Category category, Movie movie){
        CategoryDBDAO.addToCategory(category, movie);
    
    }
    
    public void clearCategory(Category category){
        CategoryDBDAO.clearCategory(category);
    
    }
    
    public boolean clearMovieFromPlayList(Category category, Movie movie){
    
        return clearMovieFromPlayList(category, movie);
    }
    
    
    
}
