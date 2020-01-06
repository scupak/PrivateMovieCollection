/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.dal.database;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mytunes.be.Song;
import mytunes.dal.SongFacade;

/**
 *DBDAO for songs. her we write at to and retrive songsfrom the databse.
 * @author andreasvillumsen
 */
public class SongDBDAO implements SongFacade {

    private final DatabaseConnector dbCon;

    /**
     * SongDBDAO constructor
     */
    public SongDBDAO() {
        dbCon = new DatabaseConnector();
    }

    /**
     * List over all songs in database
     *
     * @return list of songs
     */
    @Override
    public List<Song> getAllSongs() {
        ArrayList<Song> songs = new ArrayList<>();

        try ( Connection con = dbCon.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM song");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String album = rs.getString("album");
                String artist = rs.getString("artist");
                String category = rs.getString("category");
                int time = rs.getInt("time");
                String path = rs.getString("path");
                String timetext = "antoni";
                songs.add(new Song(id, title, album, artist, category, time, path, timetext));
            }
            return songs;

        } catch (SQLServerException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * Create a new song in the database
     *
     * @param song
     * @return boolean
     */
    public Song createSong(Song song) {
        try ( Connection con = dbCon.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO song "
                    + "(title, album, artist, category, time, path) "
                    + "VALUES (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, song.getTitle());
            ps.setString(2, song.getAlbum());
            ps.setString(3, song.getArtist());
            ps.setString(4, song.getCategory());
            ps.setInt(5, song.getTime());
            ps.setString(6, song.getPath());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                song.setId((int) rs.getLong(1));
            } else {
                return null;
            }

            return song;

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
     * @param song
     * @return boolean
     */
    public boolean updateSong(Song song) {
        try ( Connection con = dbCon.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE song SET title = ?, album = ?, artist = ?, category = ?, time = ?, path = ? WHERE id = ?");
            ps.setString(1, song.getTitle());
            ps.setString(2, song.getAlbum());
            ps.setString(3, song.getArtist());
            ps.setString(4, song.getCategory());
            ps.setInt(5, song.getTime());
            ps.setString(6, song.getPath());
            ps.setInt(7, song.getId());
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
     * Deletes a song from the database
     *
     * @param song
     * @return boolean
     */
    public boolean deleteSong(Song song) {

        try ( Connection con = dbCon.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM song WHERE id = ?");
            ps.setInt(1, song.getId());

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
