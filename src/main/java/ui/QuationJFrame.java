package ui;
import db.DatabaseManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.IncorrectAnswers;
import model.Task;
import ui_components.RoundJButton;
import ui_components.RoundJTextArea;

public class QuationJFrame extends javax.swing.JFrame {
    private int levelNumb;
    private int subjectNumb;
    private final DatabaseManager dbManager;
    
    public QuationJFrame(int levelNumb, int subjectNumb, DatabaseManager dbManager) {
        this.dbManager = dbManager;
        this.levelNumb = levelNumb;
        this.subjectNumb =  subjectNumb;
        initComponents();
	setupAnswers();
    }

    private void setupAnswers() {
        try {
            Task task = dbManager.getTaskWithCorrectAnswer(levelNumb, subjectNumb);
            if (task == null) return;

            List<IncorrectAnswers> answers = dbManager.getUncorrectAnswerForTask(
                task.getTaskId(), subjectNumb);

            if (answers != null && answers.size() == 4) {
                var1Label.setText(answers.get(0).getAnswerText());
                var2Label.setText(answers.get(1).getAnswerText());
                var3Label.setText(answers.get(2).getAnswerText());
                var4Label.setText(answers.get(3).getAnswerText());
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        questionLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        exitButton = new RoundJButton();
        jPanel2 = new javax.swing.JPanel();
        var1Label = new javax.swing.JLabel();
        var2Label = new javax.swing.JLabel();
        var3Label = new javax.swing.JLabel();
        var4Label = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionTextArea = new RoundJTextArea();
        jLabel1 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 30), new java.awt.Dimension(0, 30), new java.awt.Dimension(32767, 20));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 30), new java.awt.Dimension(0, 30), new java.awt.Dimension(32767, 30));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(700, 410));
        setPreferredSize(new java.awt.Dimension(700, 410));

        jPanel11.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jPanel1.setLayout(new java.awt.BorderLayout(0, 5));

        questionLabel.setText(dbManager.getLevel(levelNumb).getName());
        questionLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        questionLabel.setPreferredSize(new java.awt.Dimension(57, 20));
        jPanel1.add(questionLabel, java.awt.BorderLayout.PAGE_START);

        jPanel3.setPreferredSize(new java.awt.Dimension(323, 40));
        jPanel3.setLayout(new java.awt.CardLayout());

        exitButton.setText("Закончить викторину");
        exitButton.setBorder(null);
        exitButton.setPreferredSize(new java.awt.Dimension(119, 40));
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        jPanel3.add(exitButton, "card2");

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.GridLayout(4, 1, 0, 1));

        var1Label.setText("");
        var1Label.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(var1Label);

        var2Label.setText("");
        var2Label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(var2Label);

        var3Label.setText("");
        var3Label.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(var3Label);

        var4Label.setText("");
        var4Label.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(var4Label);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel11.add(jPanel1);

        jPanel5.setLayout(new java.awt.BorderLayout(0, 5));

        questionTextArea.setEditable(false);
        questionTextArea.setColumns(20);
        questionTextArea.setRows(5);
        questionTextArea.setText(dbManager.getTaskWithCorrectAnswer(levelNumb,subjectNumb).getDescription());
        questionTextArea.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        questionTextArea.setMargin(new java.awt.Insets(20, 20, 10, 10));
        jScrollPane1.setViewportView(questionTextArea);

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Задание:");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel11.add(jPanel5);

        getContentPane().add(jPanel11, java.awt.BorderLayout.CENTER);
        getContentPane().add(filler1, java.awt.BorderLayout.LINE_START);
        getContentPane().add(filler2, java.awt.BorderLayout.LINE_END);
        getContentPane().add(filler3, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(filler4, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        JokesJFrame jokesJFrame = new JokesJFrame(levelNumb, subjectNumb, dbManager);
        jokesJFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JTextArea questionTextArea;
    private javax.swing.JLabel var1Label;
    private javax.swing.JLabel var2Label;
    private javax.swing.JLabel var3Label;
    private javax.swing.JLabel var4Label;
    // End of variables declaration//GEN-END:variables
}
