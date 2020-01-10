/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*Here the package that this class is in is defined*/
package privateMovieCollection.gui;

/*All the imports are defined here,the class needs to know witch other classes, packages or libraries it has acces to,
this also defines how the class fits into the programs design structure.*/
import java.awt.FileDialog;
import java.io.File;
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
/**
 * NewSongController is the class that controls the fxml page where the user can
 * create and add new songs to the app
 */
public class NewMovieController implements Initializable {
    
    
    private AppModel appModel;
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
    private Button cancel;
    @FXML
    private Button Save;
    @FXML
    private TextField fileTextField;
    
    @FXML
    private TextField categoryTextField;
    @FXML
    private Button movieChoiceButton;
    @FXML
    private Button Cancel;
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
     * we need to make sure that the controller uses the same appmodel as the
     * rest of the program otherwise it would be wotking with diferent datasets.
     * We therefore have a method that we call when the fxml stage is set where
     * the correct appmodel is passed to the controller.
     */
    public void setAppModel(AppModel app) {
        appModel = app;
    }

 

    @FXML
    private void Save(ActionEvent event)
    {
        String title = movieTitleTextField.getText(); 
        String category = categoryTextField.getText();
        String moviePath = fileTextField.getText();
        String raiting = raitingTextField.getText();
        Date lastView = new Date();
        int intRaiting;
        
        try{
            intRaiting = Integer.parseInt(raiting);
        } catch(NumberFormatException e){
            intRaiting = 0;
        }

        Movie movieToAdd = new Movie(1, title, intRaiting,"","", moviePath, lastView); 
        //System.out.println("closed");
        appModel.createMovie(movieToAdd);
                try{
        cancel(event);
           
        }
        catch(NullPointerException exeption){
            System.out.println(event);
             //exeption.printStackTrace();
            JOptionPane.showMessageDialog(null, "invalid input or movie with same name already");
        
        }
       
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

    @FXML
    private void cancel(ActionEvent event)
    {
        Stage stage = (Stage) Cancel.getScene().getWindow();
        System.out.println(cancel);
        
        stage.close();
    }
    
}
