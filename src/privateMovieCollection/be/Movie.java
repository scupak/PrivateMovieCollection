/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.be;

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
    
    /**
     * Movie constructor
     * @param id
     * @param title
     */
    public Movie(int id, String title, int rating) {
        this.id = id;
        this.title = new SimpleStringProperty(title);
        this.rating = new SimpleIntegerProperty(rating);
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
}
