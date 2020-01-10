/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
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
import privateMovieCollection.be.Category;
import privateMovieCollection.be.Movie;
import privateMovieCollection.gui.AppModel;

/**
 *
 * @author andreasvillumsen
 */
public class AppController implements Initializable {

    @FXML
    private Button newMoiveButton;
    @FXML
    private Button play;

    
    
    enum ListSelection {
        MOVIES, MOVIESINCATEGORY, CATEGORY,
    }
    
    ListSelection listSelection = ListSelection.MOVIES;
    private AppModel appModel;

    @FXML
    private ListView<Movie> moviesInCategory;
    @FXML
    private TextField searchField;
    @FXML
    private Button editMovieButton;
    @FXML
    private Button deleteSongButton;
    @FXML
    private Button exitButton;
    @FXML
    private TableView<Movie> movieList;
    @FXML
    private TableView<Category> categoryList;
    @FXML
    private TableColumn<Movie, String> movieTitelCol;
    @FXML
    private TableColumn<Movie, String> movieCategoryCol;
    @FXML
    private TableColumn<Movie, String> movieRaitingCol;
    @FXML
    private TableColumn<Category,  String> categoryNameCol;
    @FXML
    private TableColumn<Category, Integer> moviesInCategoryCol;
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
         
         movieRaitingCol.setCellValueFactory( 
                new PropertyValueFactory<Movie, String>("rating")
        
        );
         
        categoryNameCol.setCellValueFactory( 
                new PropertyValueFactory<Category, String>("name")
        
        ); 
        
        moviesInCategoryCol.setCellValueFactory( 
                new PropertyValueFactory<Category, Integer>("movies")
        
        ); 
         
         
        try   
        {
            appModel = new AppModel();
       

        minimumRatingSlider.valueProperty().addListener(new InvalidationListener() {
                    @Override
                    public void invalidated(Observable observable) {

                        minimumRatingLabel.setText(Math.round(minimumRatingSlider.getValue())+"");
                    }
                });
        
        movieList.setItems(appModel.getAllMovies());
       categoryList.setItems(appModel.getAllCategories());
       moviesInCategory.setItems(appModel.getAllMovies());
        
       /* System.out.println("");
        System.out.println(appModel.getAllMoviesInCategory(appModel.getAllCategories().get(0)));
        System.out.println("");*/
       
       } catch (Exception ex)
        {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickedOnMovieInCategory(MouseEvent event)
    {
        listSelection = listSelection.MOVIESINCATEGORY;
    }

    @FXML
    private void play(ActionEvent event) throws IOException
    {
        Date lastview = new Date();
        
        if(listSelection == listSelection.MOVIES)
        {
            appModel.getVideoPlayer().playVideo(movieList.getSelectionModel().getSelectedItem().getPath());
            movieList.getSelectionModel().getSelectedItem().setLastview(lastview);
            appModel.updateMovie(movieList.getSelectionModel().getSelectedItem());
        }
        else if(listSelection == listSelection.MOVIESINCATEGORY)
        {
            appModel.getVideoPlayer().playVideo(moviesInCategory.getSelectionModel().getSelectedItem().getPath());
            Movie movieUpdate = moviesInCategory.getSelectionModel().getSelectedItem();
            movieUpdate.setLastview(lastview);
            appModel.updateMovie(movieUpdate);
            
        }
    }

    @FXML
    private void newMovie(ActionEvent event) throws IOException
    {
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
        cont.setMovie(movieList.getSelectionModel().getSelectedItem());
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
        listSelection = ListSelection.MOVIES;
    }

    @FXML
    private void updateCategoryView(MouseEvent event)
    {
        System.out.println("fuck fuck");
        if(categoryList.getSelectionModel().getSelectedItem() != null){
            
            listSelection  = ListSelection.CATEGORY;
            moviesInCategory.setItems(appModel.getAllMoviesInCategory(categoryList.getSelectionModel().getSelectedItem()));
        
        }
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
    
    public static void main(String[] args) throws Exception {
         
         AppModel am = new AppModel();
        ArrayList<Category> categories = new ArrayList<>();
        
         //System.out.println(am.getAllCategories()); 
        
       System.out.println(am.getAllMoviesInCategory(am.getAllCategories().get(0)));
        
        
        
    }

}
