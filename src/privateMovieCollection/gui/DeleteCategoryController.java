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
import privateMovieCollection.be.Category;

/**
 *
 * @author lumby
 */
public class DeleteCategoryController
{

    private AppModel appModel;
    private Category category;
    
    @FXML
    private Button yes;
    @FXML
    private Button no;

    
     public void setAppModel(AppModel app) {
        appModel = app;
    }
     
     public void setCategory(Category category){
         this.category = category;
     }
    
    @FXML
    private void yes(ActionEvent event)
    {
        appModel.deleteCategory(category);
        appModel.categoriesClearAdd();
        appModel.movieClearAdd();
        appModel.moviesInCategoriesClearAdd(category);
        no(event);
    }

    @FXML
    private void no(ActionEvent event)
    {
        Stage stage = (Stage) no.getScene().getWindow();
        stage.close();
    }
    
}
