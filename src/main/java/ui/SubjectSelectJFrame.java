package ui;

import ui_components.RoundJButton;
import ui_components.RoundJPanel;
import javax.swing.ImageIcon;

public class SubjectSelectJFrame extends javax.swing.JFrame {
    public SubjectSelectJFrame() {
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new RoundJPanel();
        programmingButton = new RoundJButton();
        statisticSubjectButton = new RoundJButton();
        linearAlgebraButton = new RoundJButton();
        linearAlgebraLabel = new javax.swing.JLabel();
        programmingLabel = new javax.swing.JLabel();
        statisticLabel = new javax.swing.JLabel();
        backButton = new RoundJButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Выберите предмет");
        setLocationByPlatform(true);

        programmingButton.setText("Си/C++");
        programmingButton.setBorder(null);
        programmingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programmingButtonActionPerformed(evt);
            }
        });

        statisticSubjectButton.setText("Мат.стат.");
        statisticSubjectButton.setBorder(null);
        statisticSubjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statisticSubjectButtonActionPerformed(evt);
            }
        });

        linearAlgebraButton.setText("Линейная алгебра");
        linearAlgebraButton.setBorder(null);
        linearAlgebraButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linearAlgebraButtonActionPerformed(evt);
            }
        });

        linearAlgebraLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/linearAlg.png"))); // NOI18N
        linearAlgebraLabel.setLabelFor(linearAlgebraButton);
        linearAlgebraLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        programmingLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/proga.png"))); // NOI18N
        programmingLabel.setLabelFor(programmingButton);
        programmingLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        statisticLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mathStat.png"))); // NOI18N
        statisticLabel.setLabelFor(statisticSubjectButton);
        statisticLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        backButton.setText("Назад");
        backButton.setBorder(null);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statisticLabel)
                            .addComponent(statisticSubjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(linearAlgebraLabel)
                                .addGap(18, 18, 18)
                                .addComponent(programmingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(linearAlgebraButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(programmingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(statisticLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(linearAlgebraLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(programmingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statisticSubjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(linearAlgebraButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(programmingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void statisticSubjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statisticSubjectButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statisticSubjectButtonActionPerformed

    private void linearAlgebraButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linearAlgebraButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_linearAlgebraButtonActionPerformed

    private void programmingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programmingButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_programmingButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        MainMenuJFrame mainMenu = new MainMenuJFrame();
        mainMenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel jPanel;
    private javax.swing.JButton linearAlgebraButton;
    private javax.swing.JLabel linearAlgebraLabel;
    private javax.swing.JButton programmingButton;
    private javax.swing.JLabel programmingLabel;
    private javax.swing.JLabel statisticLabel;
    private javax.swing.JButton statisticSubjectButton;
    // End of variables declaration//GEN-END:variables
}
