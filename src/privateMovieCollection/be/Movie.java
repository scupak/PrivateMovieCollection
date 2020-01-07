/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.be;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author andreasvillumsen
 */
public class Movie {
    private int id;
    private final SimpleStringProperty title;
    
    /**
     * Movie constructor
     * @param id
     * @param title
     */
    public Movie(int id, String title) {
        this.id = id;
        this.title = new SimpleStringProperty(title);
    }
    
    /**
     * Get the id of the song
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id of the song
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Get the title of the song
     *
     * @return title
     */
    public String getTitle() {
        return title.get();
    }

    /**
     * Set the title of the song
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title.set(title);
    }
}
