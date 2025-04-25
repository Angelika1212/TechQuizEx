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

        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel = new RoundJPanel();
        levelMapButton = new RoundJButton();
        achivementButton = new RoundJButton();
        logOutButton = new RoundJButton();
        exitButton = new RoundJButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Основное меню");

        jPanel4.setPreferredSize(new java.awt.Dimension(0, 30));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel3.setMinimumSize(new java.awt.Dimension(0, 30));
        jPanel3.setPreferredSize(new java.awt.Dimension(356, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel1.setPreferredSize(new java.awt.Dimension(20, 240));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

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

        jPanel2.setPreferredSize(new java.awt.Dimension(20, 240));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_END);

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
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton levelMapButton;
    private javax.swing.JButton logOutButton;
    // End of variables declaration//GEN-END:variables
}
