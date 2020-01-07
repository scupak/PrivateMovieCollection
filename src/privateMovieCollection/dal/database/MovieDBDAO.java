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
import java.util.ArrayList;
import java.util.List;
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
                movies.add(new Movie(id, title));
            }
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
        try ( Connection con = dbCon.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO movie "
                    + "(title) "
                    + "VALUES (?)", Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, movie.getTitle());
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
        try ( Connection con = dbCon.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE movie SET title = ? WHERE id = ?");
            ps.setString(1, movie.getTitle());
            ps.setInt(2, movie.getId());
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
}
