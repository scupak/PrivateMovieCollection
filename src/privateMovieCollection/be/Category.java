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
public class Category {
    private int id;
    private final SimpleStringProperty name;
    
    /**
     * Movie constructor
     * @param id
     * @param name
     */
    public Category(int id, String name) {
        this.id = id;
        this.name = new SimpleStringProperty(name);
    }
    
    /**
     * Get the id of the category
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id of the category
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Get the name of the category
     *
     * @return name
     */
    public String getName() {
        return name.get();
    }

    /**
     * Set the name of the category
     *
     * @param name
     */
    public void setName(String title) {
        this.name.set(title);
    }
}
