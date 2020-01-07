/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.be;

import java.util.Date;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author andreasvillumsen
 */
public class Movie {
    private int id;
    private final SimpleStringProperty title;
    private final SimpleIntegerProperty rating;
    private String path;
    private Date lastview;
    
    /**
     * Movie constructor
     * @param id
     * @param title
     */
    public Movie(int id, String title, int rating, String path, Date lastview) {
        this.id = id;
        this.title = new SimpleStringProperty(title);
        this.rating = new SimpleIntegerProperty(rating);
        this.path = path;
        this.lastview = lastview;
    }
    
    /**
     * Get the id of the movie
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id of the movie
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Get the title of the movie
     *
     * @return title
     */
    public String getTitle() {
        return title.get();
    }

    /**
     * Set the title of the movie
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title.set(title);
    }
    
    /**
     * Get the rating of the movie
     * 
     * @return rating
     */
    public int getRating() {
        return rating.get();
    }
    
    /**
     * Set the rating of the movie
     * 
     * @param rating
     */
    public void setRating(int rating) {
        this.rating.set(rating);
    }

    /**
     * Get the path of the movie
     * 
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * Set the path of the movie
     * 
     * @return path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Get the lastview of the movie
     * 
     * @return lastview
     */
    public Date getLastview() {
        return lastview;
    }

    /**
     * Get the lastview of the movie
     * 
     * @return lastview
     */
    public void setLastview(Date lastview) {
        this.lastview = lastview;
    }

    /**
     * This class as a String
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", title=" + title + ", rating=" + rating + ", path=" + path + ", lastview=" + lastview + '}';
    }
        
}
