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
    public List<Movie> search(String titleQuery, ArrayList<String> filterQuery, int ratingQuery)
    {
        List<Movie> searchBase = movieDBDAO.getAllMovies();
        List<Movie> titleResult = new ArrayList<>();
        List<Movie> filterResult = new ArrayList<>();
        List<Movie> finalResult = new ArrayList<>();
    
        if (titleQuery == null)
        {
            titleResult.addAll(searchBase);
        }
        else
        {
            for (Movie movie : searchBase)
            {
                if (movie.getTitle().toLowerCase().contains(titleQuery.toLowerCase()))
                {
                    titleResult.add(movie);
                }
            }
        }
        
        if (filterQuery == null)
        {
            filterResult.addAll(titleResult);
        }
        else
        {
            for (String string : filterQuery)
            {
                for (Movie movie : titleResult)
                {
                    for (Category category : movie.getCategoryArray())
                    {
                        if (category.getName().toLowerCase().contains(string.toLowerCase()))
                        {
                            filterResult.add(movie);
                        }
                    }
                }
            }
        }
        
        if (ratingQuery == 0)
        {
            finalResult.addAll(filterResult);
        }
        else
        {
            for (Movie movie : filterResult)
            {
                if (movie.getRating() > ratingQuery )
                {
                    finalResult.add(movie);
                }
            }
        }
        return finalResult;
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
