package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.time.LocalTime;
import java.util.Scanner;

public class DAO {
    private static DAO instance;
    private Connection conn;
    private ObservableList<Highscore> highscores = FXCollections.observableArrayList();
    private PreparedStatement getAllHighscoresQuerry, addHighscoreQuerry, deleteAllHighscoresQuerry, getNewUserIdQuery;

    public static DAO getInstance() {
        if (instance == null) instance = new DAO();
        return instance;
    }

    public Connection getConn() {
        return conn;
    }

    public static void removeInstance() {
        if (instance == null) return;
        instance.close();
        instance = null;
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private DAO() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:baza.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            getAllHighscoresQuerry = conn.prepareStatement("SELECT username, time FROM highscores");
        } catch (SQLException e) {
            regenerateDatabase();
            try {
                getAllHighscoresQuerry = conn.prepareStatement("SELECT username, time FROM highscores");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        try {
            addHighscoreQuerry = conn.prepareStatement("INSERT INTO highscores VALUES(?, ?, ?)");
            getNewUserIdQuery = conn.prepareStatement("SELECT MAX(id) + 1 FROM highscores");
            deleteAllHighscoresQuerry = conn.prepareStatement("DELETE from highscores");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ResultSet rs = getAllHighscoresQuerry.executeQuery();
            while (rs.next()) {
                highscores.add(new Highscore(rs.getString(1), LocalTime.parse(rs.getString(2))));
            }
            FXCollections.sort(highscores);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void regenerateDatabase() {
        try {
            String querry = "";
            Scanner scanner = new Scanner(new FileInputStream(System.getProperty("user.dir") + "/resources/sql/DBdefault.sql"));
            while (scanner.hasNext()) {
                querry += scanner.nextLine();
                if (querry.length() > 1 && querry.charAt(querry.length() - 1) == ';') {
                    Statement statement = conn.createStatement();
                    statement.execute(querry);
                    querry = "";
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addHighscore(String username, String time) {
        int id = 1;
        try {
            ResultSet rs = getNewUserIdQuery.executeQuery();
            if (rs.next())
                id = rs.getInt(1);
            addHighscoreQuerry.setInt(1, id);
            addHighscoreQuerry.setString(2, username);
            addHighscoreQuerry.setString(3, time);
            addHighscoreQuerry.executeUpdate();
            highscores.add(new Highscore(username, LocalTime.parse(time)));
            FXCollections.sort(highscores);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllHighscores() {
        try {
            deleteAllHighscoresQuerry.executeUpdate();
            highscores.removeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Highscore> getHighscores() {
        return highscores;
    }
}
