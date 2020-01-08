/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.bll;

import java.util.List;
import privateMovieCollection.be.Category;
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
    
    public List<Category> getAllCategories(){
    
        return CategoryDBDAO.getAllCategories();
    }
    
}
