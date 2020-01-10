/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.gui;

import java.awt.FileDialog;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import privateMovieCollection.be.Movie;

/**
 * FXML Controller class
 *
 * @author lumby
 */
/* This class controls the fxml that lets the user edit songs*/
public class EditMovieController implements Initializable {

    private AppModel appModel;
    private Movie movie;
    private String filename = "";
    private String directory = "";
    
    @FXML
    private Label CategoryLabel;
    @FXML
    private Label TimeLabel;
    @FXML
    private Label fileLabel;
    @FXML
    private TextField movieTitleTextField;
    @FXML
    private Button cancelButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button movieChoiceButton;
    @FXML
    private TextField fileTextField;
    @FXML
    private TextField categoryTextField;
    @FXML
    private TextField raitingTextField;


    /**
     * Initializes the controller class. Creates a list of categories and sets
     * it to the choiceBox.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    /**
     * Set the AppModel
     *
     * We need to make sure that the controller uses the same appmodel as the
     * rest of the program otherwise it would be working with different datasets.
     * We therefore have a method that we call when the fxml stage is set where
     * the correct appmodel is passed to the controller.
     *
     * @param app
     */
    public void setAppModel(AppModel app) {
        appModel = app;
    }

    @FXML
    private void cancel(ActionEvent event)
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void save(ActionEvent event)
    {
        String title = movieTitleTextField.getText(); 
        String category = categoryTextField.getText();
        String moviePath = fileTextField.getText();
        String raiting = raitingTextField.getText();
        int intRaiting;
        
        try{
            intRaiting = Integer.parseInt(raiting);
        } catch(NumberFormatException e){
            intRaiting = 0;
        }
        
        Movie movieToUpdate = new Movie(movie.getId(), title, intRaiting,"","", moviePath, movie.getLastview()); 
        appModel.updateMovie(movieToUpdate);
        cancel(event);
    }

    @FXML
    private void movieChoiceButton(ActionEvent event)
    {
         FileDialog fd = new java.awt.FileDialog((java.awt.Frame) null);
        fd.setDirectory("C:\\");
        fd.setFile("*.mp4;*.mpeg4");
        fd.setVisible(true);
        filename = fd.getFile();
        directory = fd.getDirectory();
        if (filename == null) {
            JOptionPane.showMessageDialog(null, "Add song canceled");
        } else {
            fileTextField.setText("movies/" + filename);
        }
    }
    
    public void setMovie(Movie movie) {
        this.movie = movie;

        movieTitleTextField.setText(movie.getTitle());
        categoryTextField.setText(movie.getCategories());
        raitingTextField.setText(movie.getRating() + "");
        fileTextField.setText(movie.getPath());
    }
       
}
