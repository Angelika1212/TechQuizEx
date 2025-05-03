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
    private static ArrayList<Achievement> ACHIEVEMENTS;
    private ArrayList<Integer> userAchievement;
    
    private void setAchievementArr(){
        ArrayList<Achievement> ACHIEVEMENTS = databasemanager.getAchievements();
    }
   
    public AchievementsWindow(DatabaseManager databasemanager, int userId) {
        this.databasemanager = databasemanager;
        this.userId = userId;
        this.userAchievement = databasemanager.getUserAchievement(userId);
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

        updateAchievements();
        setVisible(true);
    }

    private void updateAchievements() {
        JPanel panel = achievementsPanel;
        panel.removeAll(); 
        for (int i = 0; i < ACHIEVEMENTS.size(); i++) {
            AchievementPanel achievementPanel = new AchievementPanel(ACHIEVEMENTS.get(i).getName(), 
                    ACHIEVEMENTS.get(i).getDescription() + ACHIEVEMENTS.get(i).getName(), 
                    userAchievement.contains(ACHIEVEMENTS.get(i).getAchievement()));
            panel.add(achievementPanel);
        }

        panel.revalidate(); 
        panel.repaint(); 
    }
}
