/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import privateMovieCollection.be.Movie;
import privateMovieCollection.gui.AppModel;

/**
 *
 * @author andreasvillumsen
 */
public class AppController implements Initializable {
    private AppModel appModel;

    @FXML
    private ListView<?> moviesInCategory;
    @FXML
    private TextField searchField;
    @FXML
    private Button newMovieButton;
    @FXML
    private Button editMovieButton;
    @FXML
    private Button deleteSongButton;
    @FXML
    private Button exitButton;
    @FXML
    private TableView<Movie> movieList;
    @FXML
    private TableView<?> categoryList;
    @FXML
    private TableColumn<Movie, String> movieTitelCol;
    @FXML
    private TableColumn<Movie, String> movieCategoryCol;
    @FXML
    private TableColumn<Movie, String> movieRaitingCol;
    @FXML
    private TableColumn<?, ?> categoryNameCol;
    @FXML
    private TableColumn<?, ?> moviesInCategoryCol;
    @FXML
    private TableColumn<Movie, String> movieLastViewCol;
    @FXML
    private Button moveToCategoryButton;
    @FXML
    private Button newCategoryButton;
    @FXML
    private Button editCategoryButton;
    @FXML
    private Button deleteCategoryButton;
    @FXML
    private TextField filterField;
    @FXML
    private Slider minimumRatingSlider;
    @FXML
    private Label minimumRatingLabel;
    @FXML
    private TableColumn<?, ?> movieReleasseCol;
  

    /**
     * Initialize
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        movieCategoryCol.setCellValueFactory( 
                new PropertyValueFactory<Movie, String>("categories")
        
        );
        
        movieTitelCol.setCellValueFactory( 
                new PropertyValueFactory<Movie, String>("title")
        
        );
        
        
         movieLastViewCol.setCellValueFactory( 
                new PropertyValueFactory<Movie, String>("lastviewTekst")
        
        );
        try   
        {
            appModel = new AppModel();
        } catch (Exception ex)
        {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }

        minimumRatingSlider.valueProperty().addListener(new InvalidationListener() {
                    @Override
                    public void invalidated(Observable observable) {

                        minimumRatingLabel.setText(Math.round(minimumRatingSlider.getValue())+"");
                    }
                });
        
        movieList.setItems(appModel.getAllMovies());
    }

    @FXML
    private void clickedOnMovieInCategory(MouseEvent event)
    {
    }


    @FXML
    private void newMovie(ActionEvent event) throws IOException
    {
        //appModel.getVideoPlayer().playVideo("movies/y2mate.com - ayaya_ayaya_intensifies_9wnNW4HyDtg_1080p.mp4");
        
        FXMLLoader fxmlLoader = new FXMLLoader();

        Parent root = (Parent) fxmlLoader.load(getClass().getResource("NewMovie.fxml").openStream());
        NewMovieController cont = (NewMovieController) fxmlLoader.getController();
        cont.setAppModel(appModel);
        Stage stage = new Stage();
        stage.setTitle("New/Edit Movie");
        stage.setScene(new Scene(root));
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    @FXML
    private void editMoive(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader();

        Parent root = (Parent) fxmlLoader.load(getClass().getResource("EditMovie.fxml").openStream());
        EditMovieController cont = (EditMovieController) fxmlLoader.getController();
        cont.setAppModel(appModel);
        Stage stage = new Stage();
        stage.setTitle("New/Edit Movie");
        stage.setScene(new Scene(root));
        stage.setAlwaysOnTop(true);
        stage.show();
        
    }

    @FXML
    private void deleteMovie(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader();

        Parent root = (Parent) fxmlLoader.load(getClass().getResource("DeleteMovie.fxml").openStream());
        DeleteMovieController cont = (DeleteMovieController) fxmlLoader.getController();
        cont.setAppModel(appModel);
        Stage stage = new Stage();
        stage.setTitle("New/Edit Movie");
        stage.setScene(new Scene(root));
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    @FXML
    private void exit(ActionEvent event)
    {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
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
    private void newCategory(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader();

        Parent root = (Parent) fxmlLoader.load(getClass().getResource("NewCategory.fxml").openStream());
        NewCategoryController cont = (NewCategoryController) fxmlLoader.getController();
        cont.setAppModel(appModel);
        Stage stage = new Stage();
        stage.setTitle("New/Edit Category");
        stage.setScene(new Scene(root));
        stage.setAlwaysOnTop(true);
        stage.show();
        
    }

    @FXML
    private void editCategory(ActionEvent event) throws IOException
    {
         FXMLLoader fxmlLoader = new FXMLLoader();

        Parent root = (Parent) fxmlLoader.load(getClass().getResource("EditCategory.fxml").openStream());
        EditCategoryController cont = (EditCategoryController) fxmlLoader.getController();
        cont.setAppModel(appModel);
        Stage stage = new Stage();
        stage.setTitle("New/Edit Category");
        stage.setScene(new Scene(root));
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    @FXML
    private void deleteCategory(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader();

        Parent root = (Parent) fxmlLoader.load(getClass().getResource("DeleteCategory.fxml").openStream());
        DeleteCategoryController cont = (DeleteCategoryController) fxmlLoader.getController();
        cont.setAppModel(appModel);
        Stage stage = new Stage();
        stage.setTitle("New/Edit Movie");
        stage.setScene(new Scene(root));
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    @FXML
    private void searchTitle(KeyEvent event)
    {
    }

    @FXML
    private void Filter(KeyEvent event)
    {
    }

}
