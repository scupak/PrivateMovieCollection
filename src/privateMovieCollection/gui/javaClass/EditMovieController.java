/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.gui.javaClass;

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
/* This class controls the fxml that lets the user edit songs*/
public class EditMovieController implements Initializable {

    private AppModel appModel;
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
    private Button cancelbutton;
    @FXML
    private Button saveButton;
    @FXML
    private Button movieChoiceButton;
    @FXML
    private TextField fileTextField;
    @FXML
    private ChoiceBox<?> raitingChoiceBox;
    @FXML
    private TextField categoryTextField;


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
     * rest of the program otherwise it would be wotking with diferent datasets.
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
    }

    @FXML
    private void save(ActionEvent event)
    {
    }

    @FXML
    private void movieChoiceButton(ActionEvent event)
    {
    }
}
