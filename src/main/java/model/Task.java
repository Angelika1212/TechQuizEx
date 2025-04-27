package model;

public class Task {
    private int task_id;
    private int subject;
    private String description;
    private String correctAnswer;
    
    public Task() {}

    public Task(int task_id, int subject, String description, String correctAnswer) {
        this.task_id = task_id;
        this.subject = subject;
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
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
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
