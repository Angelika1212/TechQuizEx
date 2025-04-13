package ui;

import javax.swing.*;

public class MainMenuJFrame extends JFrame {
    //private static final long serialVersionUID = 2835048167582148112L;

    public MainMenuJFrame() {
        setTitle("Главное меню");
        setSize(400, 300);
        //TODO: та же самая проблема JFrame.DO_NOTHING_ON_CLOSE и собтвенная кнопка выход
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JButton levelSelectButton = new JButton("Карта уровней");
        JButton achievementsButton = new JButton("Достижения");
        JButton exitButton = new JButton("Выход");

        exitButton.addActionListener(e -> System.exit(0));

        add(levelSelectButton);
        add(achievementsButton);
        add(exitButton);

        setVisible(true);
    }
}
