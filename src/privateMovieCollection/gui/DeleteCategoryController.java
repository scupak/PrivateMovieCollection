/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author lumby
 */
public class DeleteCategoryController
{

    @FXML
    private Button yes;
    @FXML
    private Button no;

    @FXML
    private void yes(ActionEvent event)
    {
    }

    @FXML
    private void no(ActionEvent event)
    {
        Stage stage = (Stage) no.getScene().getWindow();
        stage.close();
    }
    
}
