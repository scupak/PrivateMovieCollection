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
        
        
    }
    
    public ObservableList<Movie> getAllMovies(){
    allMovies.clear();
    allMovies.addAll(movieManager.getAllMovies());
    return allMovies;
    
    }
    
    public VideoPlayer getVideoPlayer()
    {
        return videoPlayer;
    }
    
    public void createMovie(Movie movieToAdd)
    {
        movieManager.createMovie(movieToAdd);
    }
    
    public void search(String titleQuery, ArrayList<String> filterQuery, int ratingQuery)
    {
        if (titleQuery == null || filterQuery == null || ratingQuery == 0)
        {
            allMovies.clear();
            allMovies.addAll(movieManager.getAllMovies());
        }
        else
        {
            allMovies.clear();
            allMovies.addAll(movieManager.search(titleQuery, filterQuery, ratingQuery));
        }
    }
    

}
