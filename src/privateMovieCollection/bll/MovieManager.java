/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.bll;

import privateMovieCollection.dal.MovieFacade;
import privateMovieCollection.dal.database.MovieDBDAO;
import privateMovieCollection.be.Movie;

/**
 *
 * @author anton
 */
public class MovieManager {
    
    private MovieFacade movieDBDAO;
    
    public MovieManager()
    {
        movieDBDAO = new MovieDBDAO();
    }
    
    public void creatMovie(Movie movieToAdd)
    {
        movieDBDAO.createMovie(movieToAdd);
    }
}
