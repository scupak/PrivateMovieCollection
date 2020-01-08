/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author lumby
 */
public class EditCategoryController
{
    private AppModel appModel;

    @FXML
    private TextField categoryName;
    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;

    
     public void setAppModel(AppModel app) {
        appModel = app;
    }

    @FXML
    private void save(ActionEvent event)
    {
    }

    @FXML
    private void cancel(ActionEvent event)
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    
}
