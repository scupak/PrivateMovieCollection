/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.gui;

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
public class EditSongController implements Initializable
{

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
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
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
