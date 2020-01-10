/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import privateMovieCollection.be.Category;

/**
 * FXML Controller class
 *
 * @author lumby
 */
public class NewCategoryController implements Initializable
{ 
    private AppModel appModel;

    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField categoryName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    
    
    public void setAppModel(AppModel app) {
        appModel = app;
    }

    @FXML
    private void save(ActionEvent event)
    {
        String categoryTitle = categoryName.getText();
        if(categoryTitle.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "category title can not be blank!");
        } else
        {
            categoryTitle = categoryName.getText();
            Category categoryToAdd = new Category(0, categoryTitle, 0);
            appModel.createCategory(categoryToAdd);
            cancel(event);
        }
        
    }

    @FXML
    private void cancel(ActionEvent event)
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    
}
