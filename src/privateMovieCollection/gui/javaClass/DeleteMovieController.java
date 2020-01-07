/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.gui.javaClass;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 *
 * @author kacpe
 */
public class DeleteMovieController {

    private AppModel appModel;
    @FXML
    private Button yes;
    @FXML
    private Button no;

    /**
     * Sets the appModel
     *
     * @param app
     */
    public void setappmodel(AppModel app) {
        appModel = app;
    }

    @FXML
    private void yes(ActionEvent event)
    {
    }

    @FXML
    private void no(ActionEvent event)
    {
    }

}
