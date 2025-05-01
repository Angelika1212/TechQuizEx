package model;

public class Task {
    private int taskId;
    private int subject;
    private int levelId;
    private String description;
    private String correctAnswer;
    
    public Task() {}

    public Task(int taskId, int levelId, int subject, String description, String correctAnswer) {
        this.taskId = taskId;
        this.subject = subject;
        this.levelId = levelId;
        this.description = description;
        this.correctAnswer = correctAnswer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTask_id(int taskId) {
        this.taskId = taskId;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public int getSubject() {
        return subject;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
