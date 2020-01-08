/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*Here the package that this class is in is defined*/
package privateMovieCollection.gui;

/*All the imports are defined here,the class needs to know witch other classes, packages or libraries it has acces to,
this also defines how the class fits into the programs design structure.*/
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    
    @FXML
    private Label CategoryLabel;
    @FXML
    private Label TimeLabel;
    @FXML
    private Label fileLabel;
    @FXML
    private TextField movieTitelTextField;
    @FXML
    private TextField releaseTextField;
    @FXML
    private Button Cancel;
    @FXML
    private Button Save;
    @FXML
    private TextField fileTextField;
    @FXML
    private ChoiceBox<?> raitingChoiceBox;
    @FXML
    private TextField categoryTextField;

    /**
     * The instance variables er defined and some given an initial value
     */
    private AppModel appModel;
    @FXML
    private Button movieChoiceButton;

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
    private void Cancel(ActionEvent event)
    {
    }

    @FXML
    private void Save(ActionEvent event)
    {
    }

    @FXML
    private void movieChoiceButton(ActionEvent event)
    {
    }
    
}
