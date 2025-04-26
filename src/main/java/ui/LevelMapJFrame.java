package ui;
import ui_components.RoundJButton;


public class LevelMapJFrame extends javax.swing.JFrame {

    public LevelMapJFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backButton = new RoundJButton();
        jPanel6 = new javax.swing.JPanel();
        level1Button = new RoundJButton();
        level2Button = new RoundJButton();
        level3Button = new RoundJButton();
        level4Button = new RoundJButton();
        level5Button = new RoundJButton();
        level6Button = new RoundJButton();
        level7Button = new RoundJButton();
        level8Button = new RoundJButton();
        level9Button = new RoundJButton();
        examButton = new RoundJButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 30), new java.awt.Dimension(0, 30), new java.awt.Dimension(32767, 30));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 30), new java.awt.Dimension(0, 30), new java.awt.Dimension(32767, 30));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocationByPlatform(true);

        jPanel1.setLayout(new java.awt.GridLayout(12, 1, 0, 5));

        backButton.setText("Назад");
        backButton.setBorder(null);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 252, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6);

        level1Button.setText("Уровень 1");
        level1Button.setBorder(null);
        level1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level1ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(level1Button);

        level2Button.setText("Уровень 2");
        level2Button.setBorder(null);
        level2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level2ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(level2Button);

        level3Button.setText("Уровень 3");
        level3Button.setBorder(null);
        level3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level3ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(level3Button);

        level4Button.setText("Уровень 4");
        level4Button.setBorder(null);
        level4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level4ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(level4Button);

        level5Button.setText("Уровень 5");
        level5Button.setBorder(null);
        level5Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level5ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(level5Button);

        level6Button.setText("Уровень 6");
        level6Button.setBorder(null);
        level6Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level6ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(level6Button);

        level7Button.setText("Уровень 7");
        level7Button.setBorder(null);
        level7Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level7ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(level7Button);

        level8Button.setText("Уровень 8");
        level8Button.setBorder(null);
        level8Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level8ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(level8Button);

        level9Button.setText("Уровень 9");
        level9Button.setBorder(null);
        level9Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level9ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(level9Button);

        examButton.setText("Экзамен");
        examButton.setBorder(null);
        examButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examButtonActionPerformed(evt);
            }
        });
        jPanel1.add(examButton);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        getContentPane().add(filler1, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(filler2, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(filler3, java.awt.BorderLayout.LINE_START);
        getContentPane().add(filler4, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void level1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level1ButtonActionPerformed
        QuationJFrame quationJFrame = new QuationJFrame();
        quationJFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_level1ButtonActionPerformed

    private void level2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level2ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_level2ButtonActionPerformed

    private void level3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level3ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_level3ButtonActionPerformed

    private void level4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level4ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_level4ButtonActionPerformed

    private void level5ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level5ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_level5ButtonActionPerformed

    private void level6ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level6ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_level6ButtonActionPerformed

    private void level7ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level7ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_level7ButtonActionPerformed

    private void level8ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level8ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_level8ButtonActionPerformed

    private void level9ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level9ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_level9ButtonActionPerformed

    private void examButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_examButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        SubjectSelectJFrame subjectSelectJFrame = new SubjectSelectJFrame();
        subjectSelectJFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton examButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JButton level1Button;
    private javax.swing.JButton level2Button;
    private javax.swing.JButton level3Button;
    private javax.swing.JButton level4Button;
    private javax.swing.JButton level5Button;
    private javax.swing.JButton level6Button;
    private javax.swing.JButton level7Button;
    private javax.swing.JButton level8Button;
    private javax.swing.JButton level9Button;
    // End of variables declaration//GEN-END:variables
}
