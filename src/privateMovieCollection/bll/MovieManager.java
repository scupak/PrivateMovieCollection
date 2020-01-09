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
     * Movie Manager Constructor
     */
    public MovieManager() {
        movieDBDAO = new MovieDBDAO();
    }
    
    /**
     * Get the movies and assign their categories
     * 
     * @return list of movies
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
     * Search in movies
     * 
     * @param query
     * @return movies
     */
    public List<Movie> search(String titleQuery, ArrayList<String> filterQuery, int ratingQuery)
    {
        System.out.println("in search");
        List<Movie> searchBase = getAllMovies();
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
                    System.out.println(movie.getTitle().toLowerCase());
                    titleResult.add(movie);
                }
            }
        }
        
    
        if (filterQuery.get(0).isEmpty())
        {
            System.out.println("awdawdawd");
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
                        System.out.println(category.getName());
                        System.out.println("shits aktive");
                        
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
                if (movie.getRating() >= ratingQuery )
                {
                    finalResult.add(movie);
                }
            }
        }
        
        return finalResult;
    }
    
    /**
     * Pass a movie to be created.
     * 
     * @param movie 
     */
    public void createMovie(Movie movie){
        movieDBDAO.createMovie(movie);
    }
    
    /**
     * Delete a movie from the database
     * 
     * @param movie 
     */
    public void deleteMovie(Movie movie){
        movieDBDAO.deleteMovie(movie);
    }
    
    /**
     * Update a movie
     * 
     * @param movie 
     */
    public void updateMovie(Movie movie) {
        movieDBDAO.updateMovie(movie);
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
