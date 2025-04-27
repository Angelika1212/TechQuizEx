package ui;

import db.DatabaseManager;
import ui_components.AchievementPanel;
import javax.swing.*;
import java.awt.*;
import ui_components.*;

//@author fedot

public class AchievementsWindow extends JFrame {
	
    private JPanel achievementsPanel;   
    private DatabaseManager databasemanager;
    private static final String[] TEACHERS = {"Препод А", "Препод Б", "Препод В"};

    private static final String[][] ACHIEVEMENTS = {
        {
            "Достижение #1: Разрешение уравнений",
            "Достижение #2: Вычисление интегралов",
            "Достижение #3: Решение задач на геометрию",
            "Достижение #4: Разрешение уравнений",
            "Достижение #5: Вычисление интегралов",
            "Достижение #6: Решение задач на геометрию"
        },
        {
            "Достижение #1: Закон Ома",
            "Достижение #2: Ньютонов закон",
            "Достижение #3: Закон сохранения энергии"
        },
        {
            "Достижение #1: Древний",
            "Достижение #2: Пельмени",
            "Достижение #3: Олени"
        }
    };

    public AchievementsWindow() {
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
            new MainMenuJFrame(databasemanager).setVisible(true);
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
        for (String achievement : achievements) {
            AchievementPanel achievementPanel = new AchievementPanel(achievement, "Описание достижения '" + achievement + "'", true);
            panel.add(achievementPanel);
        }

        panel.revalidate(); 
        panel.repaint(); 
    }
}
