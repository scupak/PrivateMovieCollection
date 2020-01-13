/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.gui;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import privateMovieCollection.be.Category;
import privateMovieCollection.be.Movie;
import privateMovieCollection.bll.CategoryManager;
import privateMovieCollection.bll.VideoPlayer;
import privateMovieCollection.bll.MovieManager;
import privateMovieCollection.dal.PmcDalException;
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
    /**
     * 
     * @return 
     */
    public ObservableList<Movie> getAllMovies(){
    allMovies.clear();
    allMovies.addAll(movieManager.getAllMovies());
    return allMovies;
    }
   /**
    * 
    * @return 
    */
    public VideoPlayer getVideoPlayer()
    {
        return videoPlayer;
    }
    /**
     * 
     * @param movieToAdd 
     */
    public Movie createMovie(Movie movieToAdd)
    {
        Movie movie;
        movie = movieManager.createMovie(movieToAdd);
        movieClearAdd();
        
        return movie;
    }
    /**
     * 
     * @param movie 
     */
    public void deleteMovie(Movie movie){
        movieManager.deleteMovie(movie);
        movieClearAdd();
    }
    /**
     * 
     * @param movie 
     */
    public void updateMovie(Movie movie){
        movieManager.updateMovie(movie);
        movieClearAdd();
    }
    /**
     * 
     */
    public void movieClearAdd() {
        allMovies.clear();
        allMovies.addAll(movieManager.getAllMovies());
    }
    /**
     * 
     */
    public void categoriesClearAdd() throws PmcDalException{
        allCategories.clear();
        allCategories.addAll(categoryManager.getAllCategories());
    }
    /**
     * 
     * @return 
     */
    public ObservableList<Category> getAllCategories() throws PmcDalException{
    allCategories.clear();
    allCategories.addAll(categoryManager.getAllCategories());
    return allCategories;
    
    }
    /**
     * 
     * @param category
     * @return 
     */
    public ObservableList<Movie>getAllMoviesInCategory(Category category){
        moviesInCategoriesClearAdd(category);
        return moviesInCategory;
        
    }
    
    public void addToCategory(Category category, Movie movie) throws PmcDalException
    {
        categoryManager.addToCategory(category, movie);
        moviesInCategoriesClearAdd(category);
        allCategories.clear();
        allCategories.addAll(categoryManager.getAllCategories());
    }
            
            
    /**
     * 
     * @param category 
     */
    public void moviesInCategoriesClearAdd(Category category){
        moviesInCategory.clear();
        moviesInCategory.addAll(categoryManager.getAllMoviesinCategory(category));
    
    }
    /**
     * 
     * @param category 
     */
    void createCategory(Category category) throws PmcDalException{
        categoryManager.createCategory(category);
        categoriesClearAdd();
    }
    
    public void updateCategory(Category category) throws PmcDalException{
        categoryManager.updateCategory(category);
        categoriesClearAdd();
    }
    /**
     * 
     * @param category
     * @param movie
     * @return 
     */
    public boolean clearMovieFromCategory(Category category, Movie movie) throws PmcDalException{
        boolean result = categoryManager.clearMovieFromPlayList(category, movie);
        moviesInCategoriesClearAdd(category);
        categoriesClearAdd();
      
        return result;
    
    
    }
    
    public void search(String titleQuery, ArrayList<String> filterQuery, int ratingQuery)
    {
        if (filterQuery.get(0).isEmpty() && ratingQuery == 0 && titleQuery.isEmpty())
        {
            System.out.println("its empty");
            allMovies.clear();
            allMovies.addAll(movieManager.getAllMovies());
        }
        else
        {
            System.out.println(filterQuery.size());
            allMovies.clear();
            allMovies.addAll(movieManager.search(titleQuery, filterQuery, ratingQuery));
        }
    }
    
    public List<Movie> moviesToDelete(){
    
        return movieManager.moviesToDelete();
    }
    
    public void deleteCategory(Category category) throws PmcDalException{
        categoryManager.deleteCategory(category);
        categoriesClearAdd();
        movieClearAdd();
    }
    

}
