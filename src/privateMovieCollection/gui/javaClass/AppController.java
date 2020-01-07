/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.gui.javaClass;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import privateMovieCollection.gui.javaClass.AppModel;

/**
 *
 * @author andreasvillumsen
 */
public class AppController implements Initializable {
    private AppModel appModel;

    @FXML
    private ListView<?> moivesInCategory;
    @FXML
    private TextField searchField;
    @FXML
    private Button newMoiveButton;
    @FXML
    private Button editMovieButton;
    @FXML
    private Button deleteSongButton;
    @FXML
    private Button exitButton;
    @FXML
    private TableView<?> movieList;
    @FXML
    private TableView<?> categoryList;
    @FXML
    private TableColumn<?, ?> movieTitelCol;
    @FXML
    private TableColumn<?, ?> moiveCategoryCol;
    @FXML
    private TableColumn<?, ?> movieRaitingCol;
    @FXML
    private TableColumn<?, ?> categoryNameCol;
    @FXML
    private TableColumn<?, ?> moivesInCategoryCol;
    @FXML
    private TableColumn<?, ?> movieReleasseCol;
    @FXML
    private Button moveToCategoryButton;
    @FXML
    private Button newCategoryButton;
    @FXML
    private Button editCategoryButton;
    @FXML
    private Button deleteCategoryButton;
  

    /**
     * Initialize
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        try   
        {
            appModel = new AppModel();
        } catch (Exception ex)
        {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void clickedOnMovieInCategory(MouseEvent event)
    {
    }

    @FXML
    private void search(KeyEvent event)
    {
    }

    @FXML
    private void newMovie(ActionEvent event) throws IOException
    {
        appModel.getVideoPlayer().playVideo("movies/y2mate.com - ayaya_ayaya_intensifies_9wnNW4HyDtg_1080p.mp4");
    }

    @FXML
    private void editMoive(ActionEvent event)
    {
    }

    @FXML
    private void deleteMovie(ActionEvent event)
    {
    }

    @FXML
    private void exit(ActionEvent event)
    {
    }

    @FXML
    private void clickedOnMoive(MouseEvent event)
    {
    }

    @FXML
    private void updateCategoryView(MouseEvent event)
    {
    }

    @FXML
    private void moveToCategory(ActionEvent event)
    {
    }

    @FXML
    private void newCategory(ActionEvent event)
    {
    }

    @FXML
    private void editCategory(ActionEvent event)
    {
    }

    @FXML
    private void deleteCategory(ActionEvent event)
    {
    }

}
