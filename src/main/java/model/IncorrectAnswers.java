/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author fedot
 */
public class IncorrectAnswers {
    private int answer_id;
    private String answer_text;

    public IncorrectAnswers(int answer_id, String answer_text) {
        this.answer_id = answer_id;
        this.answer_text = answer_text;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public String getAnswerText() {
        return answer_text;
    }

    public void setAnswerText(String answer_text) {
        this.answer_text = answer_text;
    }
    
}
