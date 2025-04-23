/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui_components;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author fedot
 */
public class AchievementPanel extends JPanel {

    public AchievementPanel(String title, String description, boolean unlocked) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(220, 100));
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setBackground(unlocked ? new Color(0xE2FFE2) : new Color(0xF0F0F0));

        JLabel icon = new JLabel("🏆");
        icon.setFont(new Font("SansSerif", Font.PLAIN, 32));
        icon.setHorizontalAlignment(SwingConstants.CENTER);
        icon.setPreferredSize(new Dimension(60, 60));
        add(icon, BorderLayout.WEST);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        titleLabel.setForeground(unlocked ? new Color(0x006600) : Color.GRAY);

        JLabel descLabel = new JLabel("<html><body style='width:140px'>" + description + "</body></html>");
        descLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
        descLabel.setForeground(Color.DARK_GRAY);

        textPanel.add(titleLabel);
        textPanel.add(Box.createVerticalStrut(5));
        textPanel.add(descLabel);

        add(textPanel, BorderLayout.CENTER);
    }
}