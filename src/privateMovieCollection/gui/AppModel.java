/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.gui;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import privateMovieCollection.be.Category;
import privateMovieCollection.be.Movie;
import privateMovieCollection.bll.CategoryManager;
import privateMovieCollection.bll.VideoPlayer;
import privateMovieCollection.bll.MovieManager;
import privateMovieCollection.dal.database.CategoryDBDAO;

/**
 *
 * @author andreasvillumsen
 */
public class AppModel {
    private VideoPlayer videoPlayer;
    private MovieManager movieManager;
    private CategoryManager categoryManager;
    private AppController appController;
    private ObservableList<Movie> allMovies;
    private ObservableList<Category> allCategories;
    private ObservableList<Movie> moviesInCategory;
    

    /**
     * AppModel constructor
     */
    public AppModel() throws Exception {
        videoPlayer = new VideoPlayer();
        
        movieManager = new MovieManager();
        allMovies = FXCollections.observableArrayList();
        allMovies.addAll(movieManager.getAllMovies());
        
        categoryManager = new CategoryManager();
        allCategories = FXCollections.observableArrayList();
        allCategories.addAll(categoryManager.getAllCategories());
        
        moviesInCategory = FXCollections.observableArrayList();
        
        if (categoryManager.getAllCategories().size() != 0) {
            moviesInCategory.addAll(categoryManager.getAllMoviesinCategory(categoryManager.getAllCategories().get(0)));
        }
        
    }
    
    public ObservableList<Movie> getAllMovies(){
    allMovies.clear();
    allMovies.addAll(movieManager.getAllMovies());
    return allMovies;
    
    }
    
    public ObservableList<Category> getAllCategories(){
    allCategories.clear();
    allCategories.addAll(categoryManager.getAllCategories());
    return allCategories;
    
    }
    
    public ObservableList<Movie>getAllMoviesInCategory(Category category){
        moviesInCategory.clear();
        moviesInCategory.addAll(categoryManager.getAllMoviesinCategory(category));
        return moviesInCategory;
        
    }
    
    public VideoPlayer getVideoPlayer()
    {
        return videoPlayer;
    }
    
    public void createMovie(Movie movieToAdd)
    {
        movieManager.createMovie(movieToAdd);
    }
    
     public static void main(String[] args) throws Exception {
         
         AppModel am = new AppModel();
        ArrayList<Category> categories = new ArrayList<>();
        
         //System.out.println(am.getAllCategories()); 
        
       System.out.println(am.getAllMoviesInCategory(am.getAllCategories().get(0)));
        
        
        
    }
    

}
