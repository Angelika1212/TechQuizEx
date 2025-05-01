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
    private static final String[] TEACHERS = {"Матстат - Перегуда А.И.", "Линейная алгебра - Сёмина Л. Г.", "С/С++- Мирзеабасов О. А,"};
    private static String[][] ACHIEVEMENTS = new String[TEACHERS.length][TEACHERS.length*15];
    
    private void setAchievementArr(){
        ArrayList<Achievement> arr = databasemanager.getAchievements();
        for(int j = 0; j < 3; j++){
            for(int i = 0; i < 45; i++){
                ACHIEVEMENTS[j][i] = arr.get(i).getName();
            }
        }
    }
   
    public AchievementsWindow(DatabaseManager databasemanager, int userId) {
        this.databasemanager = databasemanager;
        this.userId = userId;
        setAchievementArr();
        setTitle("Достижения");
        setSize(800, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label = new JLabel("Предмет - ФИО преподавателя:");
        label.setFont(new Font("SansSerif", Font.BOLD, 14));

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        RoundJButton  backButton =  new  RoundJButton("Назад");
        backButton.setPreferredSize(new Dimension(100,30));
        backButton.addActionListener(e ->  { 
            new MainMenuJFrame(userId).setVisible(true);
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

        updateAchievements(1); // Загрузить достижения для первого преподавателя
        setVisible(true);
    }

    private void updateAchievements(int teacherIndex) {
        JPanel panel = achievementsPanel;
        panel.removeAll();
        
        String[] achievements = ACHIEVEMENTS[teacherIndex];
        for (int i = 1; i < achievements.length; i++) {
            AchievementPanel achievementPanel = new AchievementPanel(achievements[i], databasemanager.getAchievement(i).getDescription() + achievements[i], false);
            panel.add(achievementPanel);
        }

        panel.revalidate(); 
        panel.repaint(); 
    }
}
