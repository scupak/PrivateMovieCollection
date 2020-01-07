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
import privateMovieCollection.dal.CategoryFacade;
import privateMovieCollection.be.Category;

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
}
