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
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import privateMovieCollection.be.Movie;
import java.lang.NullPointerException;
import javax.swing.JFrame;
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
    private Slider raitingSlider;
    @FXML
    private Label zero;
    @FXML
    private Label hundred;
    @FXML
    private Label raitingLabel;

    /**
     * Initialize
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        raitingSlider.valueProperty().addListener(new InvalidationListener() {
                    @Override
                    public void invalidated(Observable observable) {

                        raitingLabel.setText(Math.round(raitingSlider.getValue())+"");
                    }
        });
                       
    }

    /**
     * set appModel object
     */
    public void setAppModel(AppModel app) {
        appModel = app;
    }

 

    /**
     * create a new movie 
     * @param event 
     */
    @FXML
    private void Save(ActionEvent event)
    {
        String title = movieTitleTextField.getText(); 
        String moviePath = fileTextField.getText();
        String raiting = raitingLabel.getText();
        Date lastView = new Date();
        int intRaiting;
        
        try{
            intRaiting = Integer.parseInt(raiting);
            
                
        } catch(NumberFormatException e){
            intRaiting = 0;
            JFrame jf=new JFrame();
             jf.setAlwaysOnTop(true);
             JOptionPane.showMessageDialog(jf, "invalid input or movie with same name already");
        
        }
         try{
        Movie movieToAdd = new Movie(1, title, intRaiting,"","", moviePath, lastView); 
     
        
        if(appModel.createMovie(movieToAdd) == null){

            throw new NullPointerException();

        }  
        cancel(event);
           
        }
        catch(NullPointerException exeption){
             JFrame jf=new JFrame();
             jf.setAlwaysOnTop(true);
             JOptionPane.showMessageDialog(jf, "invalid input or movie with same name already");
        
        }
       
    }

    /**
     * opens a window to find the movies file
     * @param event 
     */
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

    /**
     * closes the window without doing anything else
     * @param event 
     */
    @FXML
    private void cancel(ActionEvent event)
    {
        Stage stage = (Stage) Cancel.getScene().getWindow();
        
        stage.close();
    }
    
}
