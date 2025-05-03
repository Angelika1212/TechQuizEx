package ui;

import db.DatabaseManager;
import ui_components.AchievementPanel;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import model.Achievement;
import ui_components.*;

//@author fedot

public class AchievementsWindow extends JFrame {
	
    private JPanel achievementsPanel;   
    private DatabaseManager databasemanager;
    private int userId;
    private static final String[] TEACHERS = {"Матстат - Перегуда А.И.", "Линейная алгебра - Сёмина Л. Г.", "С/С++- Качанов Б. В."};
    private static String[][] ACHIEVEMENTS = new String[TEACHERS.length][TEACHERS.length*6];
    
    private void setAchievementArr(){
        ArrayList<Achievement> arr = databasemanager.getAchievements();
        for(int j = 0; j < 3; j++){
            for(int i = 0; i < 18; i++){
                ACHIEVEMENTS[j][i] = arr.get(i).getName();
            }
        }
    }
   
    public AchievementsWindow(DatabaseManager databasemanager, int userId) {
        this.databasemanager = databasemanager;
        this.userId = userId;
        setAchievementArr();
        setTitle("Достижения");
        setSize(800, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label = new JLabel("Предмет - ФИО преподавателя:");
        label.setFont(new Font("SansSerif", Font.BOLD, 14));

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        RoundJButton  backButton =  new  RoundJButton("Назад");
        backButton.setPreferredSize(new Dimension(100,30));
        backButton.addActionListener(e ->  { 
            new MainMenuJFrame(databasemanager, userId).setVisible(true);
            dispose(); 
        });
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);
        
        JComboBox<String> comboBox = new JComboBox<>(TEACHERS);
        comboBox.setFont(new Font("SansSerif", Font.PLAIN, 14));
        comboBox.setPreferredSize(new Dimension(350, 30));
        comboBox.addActionListener(e -> updateAchievements(comboBox.getSelectedIndex()));

        topPanel.add(label);
        topPanel.add(comboBox);
        add(topPanel, BorderLayout.NORTH);

        achievementsPanel = new JPanel();
        achievementsPanel.setLayout(new GridLayout(0, 3, 10, 10));
        achievementsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(new JScrollPane(achievementsPanel), BorderLayout.CENTER);

        updateAchievements(0); // Загрузить достижения для первого преподавателя
        setVisible(true);
    }

    private void updateAchievements(int teacherIndex) {
        JPanel panel = achievementsPanel;
        panel.removeAll();
        
        String[] achievements = ACHIEVEMENTS[teacherIndex];
        int left = 0;
        int right = 0;
        switch(teacherIndex){
            case 0 -> {
                left = 0;
                right = 6;
            }
            case 1 -> {
                left = 6;
                right = 12;
            }
            case 2 -> {
                left = 12;
                right = 18;
            }
        }
        for (int i = left; i < right; i++) {
            AchievementPanel achievementPanel = new AchievementPanel(achievements[i], databasemanager.getAchievement(i + 1).getDescription() + achievements[i], false);
            panel.add(achievementPanel);
        }

        panel.revalidate(); 
        panel.repaint(); 
    }
}
