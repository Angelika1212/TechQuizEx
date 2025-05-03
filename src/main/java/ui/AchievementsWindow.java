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
    private static String[] ACHIEVEMENTS = new String[12];
    
    private void setAchievementArr(){
        ArrayList<Achievement> arr = databasemanager.getAchievements();
        for(int i = 0; i < 12; i++){
            ACHIEVEMENTS[i] = arr.get(i).getName();
        }
    }
   
    public AchievementsWindow(DatabaseManager databasemanager, int userId) {
        this.databasemanager = databasemanager;
        this.userId = userId;
        setAchievementArr();
        setTitle("Достижения");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label = new JLabel("Все достижения");
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
        

        topPanel.add(label);
        add(topPanel, BorderLayout.NORTH);

        achievementsPanel = new JPanel();
        achievementsPanel.setLayout(new GridLayout(0, 3, 10, 10));
        achievementsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(new JScrollPane(achievementsPanel), BorderLayout.CENTER);

        updateAchievements(); // Загрузить достижения для первого преподавателя
        setVisible(true);
    }

    private void updateAchievements() {
        JPanel panel = achievementsPanel;
        panel.removeAll();
        
        for (int i = 0; i < ACHIEVEMENTS.length; i++) {
            AchievementPanel achievementPanel = new AchievementPanel(ACHIEVEMENTS[i], databasemanager.getAchievement(i + 1).getDescription() + ACHIEVEMENTS[i], false);
            panel.add(achievementPanel);
        }

        panel.revalidate(); 
        panel.repaint(); 
    }
}
