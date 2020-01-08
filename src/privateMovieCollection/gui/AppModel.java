/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.gui;

import privateMovieCollection.be.Movie;
import privateMovieCollection.bll.VideoPlayer;
import privateMovieCollection.bll.MovieManager;

/**
 *
 * @author andreasvillumsen
 */
public class AppModel {
    private VideoPlayer videoPlayer;
    private MovieManager movieManager;

    /**
     * AppModel constructor
     */
    public AppModel() throws Exception {
        videoPlayer = new VideoPlayer();
    }
    
    public VideoPlayer getVideoPlayer()
    {
        return videoPlayer;
    }
    
    public void createMovie(Movie movieToAdd)
    {
        movieManager.createMovie(movieToAdd);
    }
    

}
