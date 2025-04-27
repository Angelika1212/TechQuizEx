package ui;

import db.DatabaseManager;
import ui_components.RoundJButton;
import ui_components.RoundJPanel;

public class SubjectSelectJFrame extends javax.swing.JFrame {
    private DatabaseManager databasemanager;
    public SubjectSelectJFrame(DatabaseManager databasemanager) {
        this.databasemanager = databasemanager;
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backButton = new RoundJButton();
        jPanel = new RoundJPanel();
        jPanel5 = new javax.swing.JPanel();
        statisticLabel = new javax.swing.JLabel();
        statisticSubjectButton = new RoundJButton();
        jPanel6 = new javax.swing.JPanel();
        linearAlgebraLabel = new javax.swing.JLabel();
        linearAlgebraButton = new RoundJButton();
        jPanel7 = new javax.swing.JPanel();
        programmingLabel = new javax.swing.JLabel();
        programmingButton = new RoundJButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Выберите предмет");
        setLocationByPlatform(true);
        setMinimumSize(getPreferredSize());
        setPreferredSize(new java.awt.Dimension(600, 315));
        getContentPane().setLayout(new java.awt.BorderLayout(0, 10));

        jPanel1.setPreferredSize(new java.awt.Dimension(630, 30));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        backButton.setText("Назад");
        backButton.setBorder(null);
        backButton.setPreferredSize(new java.awt.Dimension(60, 25));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel.setLayout(new java.awt.GridLayout(1, 3, 20, 0));

        jPanel5.setLayout(new java.awt.BorderLayout(0, 10));

        statisticLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statisticLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(databasemanager.getSubject(1).getImage())));
        statisticLabel.setLabelFor(statisticSubjectButton);
        statisticLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(statisticLabel, java.awt.BorderLayout.CENTER);

        statisticSubjectButton.setText(databasemanager.getSubject(1).getName());
        statisticSubjectButton.setBorder(null);
        statisticSubjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statisticSubjectButtonActionPerformed(evt);
            }
        });
        jPanel5.add(statisticSubjectButton, java.awt.BorderLayout.PAGE_END);

        jPanel.add(jPanel5);

        jPanel6.setLayout(new java.awt.BorderLayout(0, 10));

        linearAlgebraLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        linearAlgebraLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(databasemanager.getSubject(2).getImage())));
        linearAlgebraLabel.setLabelFor(linearAlgebraButton);
        linearAlgebraLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(linearAlgebraLabel, java.awt.BorderLayout.CENTER);

        linearAlgebraButton.setText(databasemanager.getSubject(2).getName());
        linearAlgebraButton.setBorder(null);
        linearAlgebraButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linearAlgebraButtonActionPerformed(evt);
            }
        });
        jPanel6.add(linearAlgebraButton, java.awt.BorderLayout.SOUTH);

        jPanel.add(jPanel6);

        jPanel7.setLayout(new java.awt.BorderLayout(0, 10));

        programmingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        programmingLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(databasemanager.getSubject(3).getImage())));
        programmingLabel.setLabelFor(programmingButton);
        programmingLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.add(programmingLabel, java.awt.BorderLayout.CENTER);

        programmingButton.setText(databasemanager.getSubject(3).getName());
        programmingButton.setBorder(null);
        programmingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programmingButtonActionPerformed(evt);
            }
        });
        jPanel7.add(programmingButton, java.awt.BorderLayout.SOUTH);

        jPanel.add(jPanel7);

        getContentPane().add(jPanel, java.awt.BorderLayout.CENTER);
        getContentPane().add(filler1, java.awt.BorderLayout.LINE_END);
        getContentPane().add(filler2, java.awt.BorderLayout.LINE_START);
        getContentPane().add(filler3, java.awt.BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void statisticSubjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statisticSubjectButtonActionPerformed
        LevelMapJFrame levelMapJFrame = new LevelMapJFrame(1,databasemanager);
        levelMapJFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_statisticSubjectButtonActionPerformed

    private void linearAlgebraButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linearAlgebraButtonActionPerformed
        LevelMapJFrame levelMapJFrame = new LevelMapJFrame(2,databasemanager);
        levelMapJFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_linearAlgebraButtonActionPerformed

    private void programmingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programmingButtonActionPerformed
        LevelMapJFrame levelMapJFrame = new LevelMapJFrame(3,databasemanager);
        levelMapJFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_programmingButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        MainMenuJFrame mainMenu = new MainMenuJFrame(databasemanager);
        mainMenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JButton linearAlgebraButton;
    private javax.swing.JLabel linearAlgebraLabel;
    private javax.swing.JButton programmingButton;
    private javax.swing.JLabel programmingLabel;
    private javax.swing.JLabel statisticLabel;
    private javax.swing.JButton statisticSubjectButton;
    // End of variables declaration//GEN-END:variables
}
