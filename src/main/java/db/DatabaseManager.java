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
import model.Joke;
import model.LevelDb;
import model.Subject;
import model.User;
import model.Task;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5433/Tia";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345";
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

    public boolean addUserSubjectProgress(int userId, int openedLevel) {
        String insertQuery = "INSERT INTO user_subject_progress (user_id, subject_id, opened_levels) VALUES (?, ?, ?)";

        try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {

            for(int subjectId = 1; subjectId <= 3; subjectId++) {
                insertStmt.setInt(1, userId);
                insertStmt.setInt(2, subjectId);
                insertStmt.setInt(3, openedLevel);
                insertStmt.addBatch();
            }

            insertStmt.executeBatch();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean editUserOpenedLevels(int userId, int openedLevel, int subjectNumb) {
        String insertQuery = "UPDATE user_subject_progress SET opened_levels = ? WHERE user_id = ? AND subject_id = ?";

        try (PreparedStatement updateStmt = connection.prepareStatement(insertQuery)){
            updateStmt.setInt(1, openedLevel);
            updateStmt.setInt(2, userId);
            updateStmt.setInt(3, subjectNumb);
            updateStmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getOpenedLevels(int userId, int subjectNumb) {
        String query = "SELECT opened_levels FROM user_subject_progress WHERE user_id = ? AND subject_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, userId);
            stmt.setInt(2, subjectNumb);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                int openedLevels = rs.getInt("opened_levels");
                return openedLevels;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public User getUser(int userId) {
        String query = "SELECT * FROM users WHERE user_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                String login = rs.getString("login");
                String password = rs.getString("password");
                return new User(login, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
    public ArrayList<Task> getTasks(int levelId, int subject) {
        ArrayList<Task> allTasks = new ArrayList<>();

        String query = "SELECT task_id, description, correct_answer FROM task WHERE level_id = ? AND subject = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, levelId);
            stmt.setInt(2, subject);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String description = rs.getString("description");
                String correctAnswer = rs.getString("correct_answer");
                int taskId = rs.getInt("task_id");
                allTasks.add(new Task(taskId, subject, levelId, description, correctAnswer));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allTasks;
    }

    public Task getTask(int taskId, int subject) {
        String query = "SELECT level_id, description, correct_answer FROM task WHERE task_id = ? AND subject = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, taskId);
            stmt.setInt(2, subject);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String description = rs.getString("description");
                String correctAnswer = rs.getString("correct_answer");
                int levelId = rs.getInt("level_id");
                return new Task(taskId, subject, levelId, description, correctAnswer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<IncorrectAnswers> getAnswersForTask(Task task) {
        String correctAnswer = task.getCorrectAnswer();

        ArrayList<IncorrectAnswers> allAnswers = new ArrayList<>();
        Set<String> uniqueTexts = new HashSet<>(); // Для контроля уникальности

        try (PreparedStatement stmt = connection.prepareStatement("SELECT answer_text, answer_id FROM incorrect_answers WHERE task_id = ?")) {
            stmt.setInt(1, task.getTaskId());
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

    public ArrayList<Integer> getUserAchievement(int userId) {
        ArrayList<Integer> userAchievement = new ArrayList<>();
        String query = "SELECT achievement_id FROM user_achievement WHERE user_id = ?";

        try(PreparedStatement getStatement = connection.prepareStatement(query)) {
            getStatement.setInt(1, userId);
            
            ResultSet resultSet = getStatement.executeQuery();
            while (resultSet.next()){
                userAchievement.add(resultSet.getInt("achievement_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userAchievement;
    }

    public ArrayList<Joke> loadJokes(){
        String sqlQury = "SELECT description, image FROM joke";
        ArrayList<Joke> jokes = new ArrayList<>();

        try(PreparedStatement stmt = connection.prepareStatement(sqlQury)) {
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Joke joke = new Joke(resultSet.getString("description"),
                        resultSet.getString("image"));
                jokes.add(joke);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        Collections.shuffle(jokes);
        return jokes;
    }

    public void addUserAchivement(int userId, int achivementId){
        String sqlQuery = "INSERT INTO user_achievement VALUES (?, ?)";
        try (PreparedStatement insert = connection.prepareStatement(sqlQuery)) {
            insert.setInt(1, userId);
            insert.setInt(2, achivementId);
            insert.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
