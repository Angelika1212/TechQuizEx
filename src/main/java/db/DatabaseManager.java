package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/quizex";
    private static final String USER = "postgres";
    private static final String PASSWORD = "newStart1_myadmin";
    private Connection connection;

    public DatabaseManager() {
        createConnection();
    }

    private void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean addUser(String login, String password) {
        String insertQuery = "INSERT INTO user (login, password) VALUES (?, ?)";
        
        try {
            PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
            insertStmt.setString(1, login);
            insertStmt.setString(2, password);
            insertStmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean authenticate(String login, String password) {
        String query = "SELECT * FROM user WHERE login = ? AND password = ?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, login);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /*public static Task getTaskWithAnswer(int taskId) {
        String query = "SELECT description, correct_answer FROM task WHERE task_id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, taskId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String description = rs.getString("description");
                String correctAnswer = rs.getString("correct_answer");
                return new Task(taskId, description, correctAnswer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/
}
