package ui;

import db.DatabaseManager;
import javax.swing.*;
import java.awt.*;
import model.User;
import ui_components.RoundJButton;
import ui_components.RoundJPasswordField;
import ui_components.RoundJTextField;

public class LoginJFrame extends JFrame {
    private final RoundJTextField usernameField;
    private final RoundJPasswordField passwordField;
    private final JLabel messageLabel;
    private DatabaseManager dbManager = new DatabaseManager();

    public LoginJFrame() {
        setTitle("Авторизация");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
        RoundJButton loginButton = new RoundJButton("Войти");
        RoundJButton registerButton = new RoundJButton("Регистрация");
        RoundJButton closeButton = new RoundJButton("x");
        messageLabel = new JLabel("", SwingConstants.CENTER);

        messageLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        messageLabel.setForeground(Color.RED);
        styleButton(loginButton, new Color(0, 150, 0)); // Зеленая кнопка входа
        styleButton(registerButton, new Color(70, 130, 180)); // Синяя кнопка регистрации
        styleButton(closeButton, Color.RED); // Красная кнопка закрытия
        closeButton.setPreferredSize(new Dimension(20, 20));

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

        // Панель для кнопок в одной строке
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.add(registerButton);
        buttonPanel.add(loginButton);
        buttonPanel.add(closeButton);
        formPanel.add(buttonPanel, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        formPanel.add(messageLabel, gbc);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        loginButton.addActionListener(e -> handleLogin());
        registerButton.addActionListener(e -> {
            new RegisterJFrame(this);
            setVisible(false);
        });
        closeButton.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        User user = new User(username, password);

        if (dbManager.authenticate(user)) {
            messageLabel.setText("✅ Вход успешен!");
            messageLabel.setForeground(new Color(0, 128, 0));
            openMainMenu(dbManager.getUserId(user));
        } else {
            messageLabel.setText("❌ Неверные данные!");
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
    
    private void openMainMenu(int userId) {
        JOptionPane.showMessageDialog(this, "Добро пожаловать!");
        MainMenuJFrame mainMenu = new MainMenuJFrame(dbManager, userId);
        mainMenu.setVisible(true);
        dispose();
    }
}