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
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author andreasvillumsen
 */
public class AppController implements Initializable {

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
  

    /**
     * Initialize
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
    private void newMovie(ActionEvent event)
    {
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

}
