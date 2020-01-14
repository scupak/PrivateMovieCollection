/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.gui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import privateMovieCollection.be.Category;
import privateMovieCollection.be.Movie;
import privateMovieCollection.dal.PmcDalException;

/**
 *
 * @author kacpe
 */
public class DeleteMovieController {

    private AppModel appModel;
    private Movie movie;
    @FXML
    private Button yes;
    @FXML
    private Button no;

    /**
     * Sets the appModel
     *
     * @param app
     */
    public void setAppModel(AppModel app) {
        appModel = app;
    }

    public void setMovie(Movie movie)
    {
        this.movie = movie;
    }
    
    @FXML
    private void yes(ActionEvent event)
    {
        try {
            if ( movie.getCategoryArray().isEmpty() == false )
            {
                for (Category category : movie.getCategoryArray())
                {
                    
                        appModel.clearMovieFromCategory(category,movie);
                        appModel.moviesInCategoriesClearAdd(category);
                    
                }
            }
            
            appModel.deleteMovie(movie);
            appModel.movieClearAdd();
            appModel.categoriesClearAdd();
            no(event);
        } catch (PmcDalException ex) {
             JFrame jf=new JFrame();
             jf.setAlwaysOnTop(true);
             JOptionPane.showMessageDialog(jf, ex);
            
        }
    }

    @FXML
    private void no(ActionEvent event)
    {
        Stage stage = (Stage) no.getScene().getWindow();
        stage.close();
    }

}
