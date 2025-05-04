package ui;

import db.DatabaseManager;
import javax.swing.*;
import java.awt.*;
import model.User;
import ui_components.*;

public class RegisterJFrame extends JFrame {
    private final RoundJTextField usernameField;
    private final RoundJPasswordField passwordField;
    private final JLabel messageLabel;
    private DatabaseManager dbManager = new DatabaseManager();

    public RegisterJFrame(JFrame loginScreen) {
        setTitle("Регистрация");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(mainPanel);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        usernameField = new RoundJTextField(15);
        passwordField = new RoundJPasswordField(15);
        RoundJButton registerButton = new RoundJButton("Зарегистрироваться");
        RoundJButton backButton = new RoundJButton("Назад");
        RoundJButton closeButton = new RoundJButton("x");
        messageLabel = new JLabel("", SwingConstants.CENTER);

        messageLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        messageLabel.setForeground(Color.RED);

        styleButton(backButton, new Color(100, 100, 100));
        styleButton(registerButton, new Color(0, 150, 0));
        styleButton(closeButton, Color.RED);
        closeButton.setPreferredSize(new Dimension(20, 20));

        registerButton.addActionListener(e -> handleRegistration(loginScreen));
        backButton.addActionListener(e -> {
            dispose();
            loginScreen.setVisible(true);
        });
        closeButton.addActionListener(e -> {
            dispose();
            loginScreen.setVisible(true);
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        formPanel.add(new JLabel("Логин:"), gbc);

        gbc.gridy = 1;
        formPanel.add(usernameField, gbc);

        gbc.gridy = 2;
        formPanel.add(new JLabel("Пароль:"), gbc);

        gbc.gridy = 3;
        formPanel.add(passwordField, gbc);

        gbc.gridy = 4;
        gbc.gridwidth = 1;
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.add(backButton);
        buttonPanel.add(registerButton);
        buttonPanel.add(closeButton);
        
        formPanel.add(buttonPanel, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        formPanel.add(messageLabel, gbc);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void handleRegistration(JFrame loginScreen) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        User user = new User(username, password);

        if (dbManager.addUser(user)) {
            dbManager.addUserSubjectProgress(dbManager.getUserId(user), 1);
            messageLabel.setText("✅ Регистрация успешна!");
            messageLabel.setForeground(new Color(0, 128, 0));
            dispose();
            loginScreen.setVisible(true);
        } else {
            messageLabel.setText("❌ Ошибка! Возможно, такой логин уже занят.");
            messageLabel.setForeground(Color.RED);
        }
    }

    private void styleButton(JButton button, Color color) {
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
    }
}