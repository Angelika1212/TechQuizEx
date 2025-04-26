package ui;

import ui_components.RoundJButton;
import ui_components.RoundJPanel;


public class MainMenuJFrame extends javax.swing.JFrame {
    public MainMenuJFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new RoundJPanel();
        levelMapButton = new RoundJButton();
        achivementButton = new RoundJButton();
        logOutButton = new RoundJButton();
        exitButton = new RoundJButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 30), new java.awt.Dimension(0, 30), new java.awt.Dimension(32767, 30));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 30), new java.awt.Dimension(0, 30), new java.awt.Dimension(32767, 30));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Основное меню");

        jPanel.setLayout(new java.awt.GridLayout(4, 1, 0, 5));

        levelMapButton.setText("Карта уровней");
        levelMapButton.setBorder(null);
        levelMapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                levelMapButtonActionPerformed(evt);
            }
        });
        jPanel.add(levelMapButton);

        achivementButton.setText("Достижения");
        achivementButton.setBorder(null);
        achivementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                achivementButtonActionPerformed(evt);
            }
        });
        jPanel.add(achivementButton);

        logOutButton.setText("Выйти из аккаунта");
        logOutButton.setBorder(null);
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });
        jPanel.add(logOutButton);

        exitButton.setText("Выход");
        exitButton.setBorder(null);
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        jPanel.add(exitButton);

        getContentPane().add(jPanel, java.awt.BorderLayout.CENTER);
        getContentPane().add(filler1, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(filler2, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(filler3, java.awt.BorderLayout.LINE_END);
        getContentPane().add(filler4, java.awt.BorderLayout.LINE_START);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void achivementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_achivementButtonActionPerformed
        AchievementsWindow achievementWindow = new AchievementsWindow();
        achievementWindow.setVisible(true);
        dispose();
    }//GEN-LAST:event_achivementButtonActionPerformed

    private void levelMapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_levelMapButtonActionPerformed
        SubjectSelectJFrame subjectSelectJForm = new SubjectSelectJFrame();
        subjectSelectJForm.setVisible(true);
        dispose();
    }//GEN-LAST:event_levelMapButtonActionPerformed

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        LoginJFrame loginJFrame = new LoginJFrame();
        loginJFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_logOutButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);//TODO: стоит запустить рандомный экзамен и не давать пользователю выйти
    }//GEN-LAST:event_exitButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton achivementButton;
    private javax.swing.JButton exitButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JPanel jPanel;
    private javax.swing.JButton levelMapButton;
    private javax.swing.JButton logOutButton;
    // End of variables declaration//GEN-END:variables
}
