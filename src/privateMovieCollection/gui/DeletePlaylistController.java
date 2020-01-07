/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 *
 * @author kacper
 */
public class DeletePlaylistController {

    private AppModel appModel;
    @FXML
    private Button Yes;
    @FXML
    private Button No;

    /**
     * Set the appModel object
     *
     * @param app
     */
    public void setAppModel(AppModel app) {
        appModel = app;
    }

}
