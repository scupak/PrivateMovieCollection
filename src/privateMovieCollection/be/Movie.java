/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.be;

import java.util.ArrayList;
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
    private final SimpleStringProperty categories;
    private final SimpleStringProperty lastviewText; 
    private String path;
    private Date lastview;
    private  ArrayList<Category> categoryArray;
    
    /**
     * Movie constructor
     * @param id
     * @param title
     */
    public Movie(int id, String title,int rating ,String categories ,String lastviewTekst, String path, Date lastview) {
        this.id = id;
        this.title = new SimpleStringProperty(title);
        this.rating = new SimpleIntegerProperty(rating);
        this.categories = new SimpleStringProperty(categories);
        this.lastviewText = new SimpleStringProperty();
        this.path = path;
        this.lastview = lastview;
        categoryArray = new ArrayList<>();
        
        setLastviewText(lastview.toString());
        
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
     * Get the categories as a string seperated with semicolon
     * @return categories as string
     */
    public String getCategories() {
        String text = "";
        if(!categoryArray.isEmpty()){
            int i = 1;
            for (Category category : categoryArray) {
                if(i == categoryArray.size()){
                    text = text + category.toString();
                } else {
                    text = text + category.toString() +",";
                    i++;
                }
            }
            
            setCategories(text);
        } else{
            setCategories("none");
        }
        return categories.get();
    }
    
    /**
     * Set categories
     * @param categories 
     */
    public void setCategories(String categories) {
        this.categories.set(categories);
    }
    
    /**
     * Get lastview
     * @param LastviewText 
     */
    public String getLastviewText(){
       return lastviewText.get();
    }
    /**
     * 
     * @param LastviewText 
     */
    public void setLastviewText(String LastviewText ){
        this.lastviewText.set(LastviewText);
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
     * @param path
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
     * @param lastview
     */
    public void setLastview(Date lastview) {
        this.lastview = lastview;
        
        setLastviewText(lastview.toString());
    }
    /**
     * 
     * @return 
     */
    public ArrayList<Category> getCategoryArray() {
        return categoryArray;
    }
    /**
     * 
     * @param categoryArray 
     */
    public void setCategoryArray(ArrayList<Category> categoryArray) {
        this.categoryArray = categoryArray;
    }

    /**
     * This class as a String
     * 
     * @return String
     */
    @Override
    public String toString() {
        return getTitle();
    }
        
}
