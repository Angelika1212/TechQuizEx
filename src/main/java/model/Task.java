package model;

public class Task {
    private String description;
    private String correctAnswer;

    public Task() {}

    public Task(String description, String correctAnswer) {
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

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
