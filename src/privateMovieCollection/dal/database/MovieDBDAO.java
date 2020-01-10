/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.dal.database;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import privateMovieCollection.be.Category;
import privateMovieCollection.dal.MovieFacade;
import privateMovieCollection.be.Movie;

/**
 *
 * @author andreasvillumsen
 */
public class MovieDBDAO implements MovieFacade {
    private final DatabaseConnector dbCon;
    /**
     * MovieDBDAO constructor
     */
    public MovieDBDAO() {
        dbCon = new DatabaseConnector();
    }
    
    /**
     * List over all movies in database
     *
     * @return list of movies
     */
    @Override
    public List<Movie> getAllMovies() {
        ArrayList<Movie> movies = new ArrayList<>();

        try ( Connection con = dbCon.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM movie");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                int rating = rs.getInt("rating");
                String path = rs.getString("filelink");
                java.sql.Date dbSqlDate = rs.getDate("lastview");
                Date dbSqlDateConverted = new Date(dbSqlDate.getTime());
                movies.add(new Movie(id, title, rating,"","", path, dbSqlDateConverted));
            }
            //int id, String title,int rating ,String categories ,String lastviewTekst, String path, Date lastview
            return movies;

        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * Create a new movie in the database
     *
     * @param movie
     * @return boolean
     */
    @Override
    public Movie createMovie(Movie movie) {
        if(movieExist(movie)) return null;
        
        try ( Connection con = dbCon.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO movie "
                    + "(title, rating, filelink, lastview) "
                    + "VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, movie.getTitle());
            ps.setInt(2, movie.getRating());
            ps.setString(3, movie.getPath());
            
           // SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            
            ps.setDate(4, new java.sql.Date(movie.getLastview().getTime()));
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                movie.setId((int) rs.getLong(1));
            } else {
                return null;
            }

            return movie;

        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * Updates the database
     *
     * @param movie
     * @return boolean
     */
    @Override
    public boolean updateMovie(Movie movie) {
        if(movieExist(movie)) return false;
        
        try ( Connection con = dbCon.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE movie SET title = ?, rating = ?, filelink = ?, lastview = ? WHERE id = ?");
            ps.setString(1, movie.getTitle());
            ps.setInt(2, movie.getRating());
            ps.setString(3, movie.getPath());
            ps.setDate(4, new java.sql.Date(movie.getLastview().getTime()));
            ps.setInt(5, movie.getId());
            int updatedRows = ps.executeUpdate();
            return updatedRows > 0;

        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    /**
     * Deletes a movie from the database
     *
     * @param movie
     * @return boolean
     */
    @Override
    public boolean deleteMovie(Movie movie) {
        try ( Connection con = dbCon.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM movie WHERE id = ?");
            ps.setInt(1, movie.getId());

            int updatedRows = ps.executeUpdate();
            return updatedRows > 0;

        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }
    
    /**
     * Check if a given movie title does exist in the database, 
     * but allow the same movie to be edited.
     * 
     * @param movie
     * @return true if movie exist, false if not.
     */
    public boolean movieExist(Movie movie) {
        try ( Connection con = dbCon.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM movie WHERE title = ? WHERE id != ?");
            ps.setString(1, movie.getTitle());
            ps.setInt(2, movie.getId());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                return true;
            }
            
            return false;
        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    @Override
    public List<Category> GetAllCategoriesWithMovie(Movie movie){
        ArrayList<Category> categories = new ArrayList<>();
        
        try ( Connection con = dbCon.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT "
                    + "category_movie.Categoryid,category.id,category_movie.Movieid,category.name "
                    + "FROM category_movie "
                    + "INNER JOIN category ON category_movie.categoryid = category.id "
                    + "WHERE category_movie.movieid = ? "
                    + "ORDER BY category_movie.categoryid ASC");
            
            ps.setInt(1, movie.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int categoryid = rs.getInt("Categoryid");
                String name = rs.getString("name");
            
                categories.add(new Category(categoryid, name, 0));
            }
            return categories;

        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }

    public List<Movie> searchMovies(String searchQuery, List<Category> filter, int rating) {
        if(searchQuery == null) {
            searchQuery = "";
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        ArrayList<Movie> movies = new ArrayList<>();
        ArrayList<Category> categories = new ArrayList<>();
        MovieDBDAO movieDB = new MovieDBDAO();
        
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
        // movieDB.createMovie(new Movie(1, "mello", 28, "actions/batman.mp4", new Date()));
        //movieDB.updateMovie(new Movie(6, "mello", 28, "actions/batman.mp4", new Date()));
      
        //categories.addAll(movieDB.GetAllCategoriesWithMovie(new Movie(3, "title", 0, "path", new Date(), "")));
      
        movies.addAll(movieDB.getAllMovies());
      
        for (Movie movie : movies) {
            
            System.out.println(movie);
        }
    }
}
