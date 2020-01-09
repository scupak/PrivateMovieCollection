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
        List<Movie> result = movieDBDAO.getAllMovies();
        
        
        for (Movie movie : result) {
            
            if(!movieDBDAO.GetAllCategoriesWithMovie(movie).isEmpty()){
                
                movie.getCategoryArray().addAll(movieDBDAO.GetAllCategoriesWithMovie(movie));
            
            }
        }
        
        return result;
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
    
    public static void main(String[] args) {
        
        MovieFacade movieDBDAO = new MovieDBDAO();
        MovieManager manager = new MovieManager();
        
         ArrayList<Movie> movies = new ArrayList<>();
         
         
         movies.addAll(manager.getAllMovies());
        
         for (Movie movy : movies) {
            
             System.out.println(movy);
        }
    }
    
    
    
    
}
