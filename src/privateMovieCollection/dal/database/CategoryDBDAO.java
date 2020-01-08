/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.dal.database;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import privateMovieCollection.dal.CategoryFacade;
import privateMovieCollection.be.Category;
import privateMovieCollection.be.Movie;

/**
 *
 * @author andreasvillumsen
 */
public class CategoryDBDAO implements CategoryFacade {
    private final DatabaseConnector dbCon;
    /**
     * MovieDBDAO constructor
     */
    public CategoryDBDAO() {
        dbCon = new DatabaseConnector();
    }
    
    /**
     * List over all movies in database
     *
     * @return list of movies
     */
    @Override
    public List<Category> getAllCategories() {
        ArrayList<Category> categories = new ArrayList<>();

        try ( Connection con = dbCon.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM category");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                categories.add(new Category(id, name));
            }
            return categories;

        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * Create a new category in the database
     *
     * @param category
     * @return boolean
     */
    @Override
    public Category createCategory(Category category) {
        try ( Connection con = dbCon.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO category "
                    + "(name) "
                    + "VALUES (?)", Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, category.getName());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                category.setId((int) rs.getLong(1));
            } else {
                return null;
            }

            return category;

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
     * @param category
     * @return boolean
     */
    @Override
    public boolean updateCategory(Category category) {
        try ( Connection con = dbCon.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE category SET name = ? WHERE id = ?");
            ps.setString(1, category.getName());
            ps.setInt(2, category.getId());
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
     * Deletes a category from the database
     *
     * @param category
     * @return boolean
     */
    @Override
    public boolean deleteCategory(Category category) {
        try ( Connection con = dbCon.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM category WHERE id = ?");
            ps.setInt(1, category.getId());

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
     * Get all the movies in a category from the database
     *
     * @param category
     * @return list of movies
     */
    public List<Movie> getAllMoviesInCategory(Category category) {
        ArrayList<Movie> movies = new ArrayList<>();

        try ( Connection con = dbCon.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT "
                    + "category_movie.categoryid, "
                    + "category_movie.movieid, movie.id, movie.title, movie.rating,"
                    + "movie.filelink, movie.lastview "
                    + "FROM category_movie "
                    + "INNER JOIN movie ON category_movie.movieid = movie.id "
                    + "WHERE category_movie.categoryid = ? "
                    + "ORDER BY movie.title ASC");
            ps.setInt(1, category.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                int rating = rs.getInt("rating");
                String filelink = rs.getString("filelink");
                Date lastview = rs.getDate("lastview");
                movies.add(new Movie(id, title, rating, filelink, lastview));
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
     * Add a movie to a category in database
     *
     * @param category
     * @param movie
     * @return boolean
     */
    public boolean addToCategory(Category category, Movie movie) {
        try ( Connection con = dbCon.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO category_movie "
                    + "(movieid, categoryid) VALUES (?,?)");
            ps.setInt(1, movie.getId());
            ps.setInt(2, category.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }
    
    /**
     * Deletes all the movies in a category from the database.
     *
     * @param category
     * @return boolean
     */
    public boolean clearCategory(Category category) {
        try ( Connection con = dbCon.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM category_movie WHERE categoryid = ?");
            ps.setInt(1, category.getId());
            ps.executeUpdate();

            PreparedStatement pStatement = con.prepareStatement("SELECT * FROM category_movie WHERE categoryid = ?");
            pStatement.setInt(1, category.getId());
            ResultSet rs = pStatement.executeQuery();

            while (rs.next()) {
                return false;
            }

            return true;

        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }
    
    /**
     * Deletes a single movie from a category.
     *
     * @param category
     * @param movie
     * @return boolean indicating if the deletion was successfull
     */
    public boolean clearMovieFromCategory(Category category, Movie movie) {
        try ( Connection con = dbCon.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM category_movie WHERE categoryid = ? "
                    + "AND movieid = ? ");
            ps.setInt(1, category.getId());
            ps.setInt(2, movie.getId());

            int updatedRows = ps.executeUpdate();

            if (updatedRows > 0) return true;

        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }
}
