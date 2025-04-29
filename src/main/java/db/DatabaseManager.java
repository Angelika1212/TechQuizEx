package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import model.Achievement;
import model.IncorrectAnswers;
import model.LevelDb;
import model.Subject;
import model.User;
import model.Task;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5433/Tia";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";
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

    public boolean addUser(User user) {
        String insertQuery = "INSERT INTO users (login, password) VALUES (?, ?)";
        
        try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)){
            insertStmt.setString(1, user.getLogin());
            insertStmt.setString(2, user.getPassword());
            insertStmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public int getUserId(User user){        
        String query = "SELECT user_id FROM users WHERE login = ? AND password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getPassword());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int user_id = rs.getInt("user_id");
                return user_id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean authenticate(User user) {
        String query = "SELECT * FROM users WHERE login = ? AND password = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getPassword());
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Task getTaskWithCorrectAnswer(int taskId, int subject) {
        String query = "SELECT description, correct_answer FROM task WHERE level_id = ? AND subject = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, taskId);
            stmt.setInt(2, subject);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String description = rs.getString("description");
                String correctAnswer = rs.getString("correct_answer");
                return new Task(taskId, subject, description, correctAnswer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<IncorrectAnswers> getUncorrectAnswerForTask(int taskId, int subject) {
        Task task = getTaskWithCorrectAnswer(taskId, subject);
        if (task == null || task.getCorrectAnswer() == null) {
            return null;
        }
        String correctAnswer = task.getCorrectAnswer();

        ArrayList<IncorrectAnswers> allAnswers = new ArrayList<>();
        Set<String> uniqueTexts = new HashSet<>(); // Для контроля уникальности

        try (PreparedStatement stmt = connection.prepareStatement("SELECT answer_text, answer_id FROM incorrect_answers WHERE task_id = ?")) {
            stmt.setInt(1, taskId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String text = rs.getString("answer_text");
                int id = rs.getInt("answer_id");

                if (!text.equals(correctAnswer) && uniqueTexts.add(text)) {
                    allAnswers.add(new IncorrectAnswers(id, text));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        if (allAnswers.size() < 3) {
            return null;
        }

        Collections.shuffle(allAnswers);
        ArrayList<IncorrectAnswers> result = new ArrayList<>(allAnswers.subList(0, 3));

        result.add(new IncorrectAnswers(
            allAnswers.isEmpty() ? 1 : Collections.max(
                allAnswers.stream()
                    .mapToInt(IncorrectAnswers::getAnswer_id)
                    .boxed()
                    .collect(Collectors.toList())
            ) + 1,
            correctAnswer
        ));

        Collections.shuffle(result);
        return result;
    }
    
    public Subject getSubject(int subject) {
        String query = "SELECT name, image FROM subject WHERE subject_id = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, subject);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String image = rs.getString("image");
                return new Subject(subject, name, image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public LevelDb getLevel(int level_id) {
        String query = "SELECT name, description FROM level WHERE level_id = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, level_id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                return new LevelDb(name, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Achievement getAchievement(int achievement_id) {
        String query = "SELECT name, image, description FROM achievements  WHERE achievement_id = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, achievement_id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String image = rs.getString("image");
                String description = rs.getString("description");
                return new Achievement(achievement_id, image, name, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
        
    public ArrayList<Achievement> getAchievements() {
        ArrayList<Achievement> achievements = new ArrayList<>();
        String query = "SELECT achievement_id, name, image, description FROM achievements";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int achievement_id = rs.getInt("achievement_id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                String description = rs.getString("description");
                achievements.add(new Achievement(achievement_id, image, name, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return achievements;
    }
    
    public boolean IsAchievementCompleted(int achievement_id, int user_id) {
        String query = "SELECT complete FROM achievements WHERE achievement_id = ? AND user_id = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                boolean complete = rs.getBoolean("complete");
                return complete;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
