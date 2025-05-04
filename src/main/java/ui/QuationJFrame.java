package ui;

import db.DatabaseManager;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Achievement;
import model.IncorrectAnswers;
import model.Task;
import ui_components.RoundJButton;
import ui_components.RoundJTextArea;

public class QuationJFrame extends javax.swing.JFrame {
    private String userAnswer;
    private int levelNumb;
    private int quastionNumb = 0;
    private String correctAnswer;
    private int subjectNumb;
    private final DatabaseManager dbManager;
    private ArrayList<Achievement> userAchievmentCash = new ArrayList<>();
    private HashMap<String, Achievement> allAchievements = new HashMap<>(); 
    private int userId;
        
    public QuationJFrame(int levelNumb, int subjectNumb, DatabaseManager dbManager, int userId) {
        this.dbManager = dbManager;
        this.subjectNumb = subjectNumb;
        this.levelNumb = levelNumb;
        this.userId = userId;
        loadAchivements();
        loadAchivementCashe();
        initComponents();
        setupQuastion();
    }
    
    public QuationJFrame(int levelNumb, int subjectNumb, int questionNumb, DatabaseManager dbManager, int userId) {
        this.dbManager = dbManager;
        this.subjectNumb = subjectNumb;
        this.levelNumb = levelNumb;
        this.quastionNumb = questionNumb;
        this.userId = userId;
        loadAchivements();
        loadAchivementCashe();
        initComponents();
        setupQuastion();
    }
    
    private void loadAchivements(){
        ArrayList<Achievement> achievementList = dbManager.getAchievements();
        achievementList.forEach(elem -> {
            this.allAchievements.put(elem.getName(), elem);
        });
    }
    
    private void loadAchivementCashe(){
        ArrayList<Integer> userAchiev = this.dbManager.getUserAchievement(userId);
        userAchiev.forEach(id -> {
            Achievement achiev = this.dbManager.getAchievement(id);
            this.userAchievmentCash.add(achiev);
        });
    }
    
    private void updateUserAchievements(String achievementName){
        if (!this.userAchievmentCash.contains(this.allAchievements.get(achievementName))){
            this.dbManager.addUserAchivement(userId, allAchievements.get(achievementName).getAchievement());
            this.userAchievmentCash.add(this.allAchievements.get(achievementName));
        }
    }
    
    private void checkSessionPassedCondition(){
        if (this.userAchievmentCash.contains(this.allAchievements.get("Знаток матстата")) &&
                this.userAchievmentCash.contains(this.allAchievements.get("Знаток линейной алгебры")) &&
                this.userAchievmentCash.contains(this.allAchievements.get("Знаток C/C++"))) {
            updateUserAchievements("Сессия сдана");
        }
    }

    private void setupQuastion() {
        try {
            Task task = dbManager.getTasks(levelNumb, subjectNumb).get(quastionNumb);
            if (task == null) {
                return;
            }
            correctAnswer = task.getCorrectAnswer();
            questionTextArea.setText(task.getDescription());
            jLabel1.setText("Задание #" + (quastionNumb + 1));

            List<IncorrectAnswers> answers = dbManager.getAnswersForTask(
                    task);

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

    private String chooseAnswer(javax.swing.JLabel varIlabel) {
        ArrayList<javax.swing.JLabel> labels = new ArrayList<>();
        labels.add(this.var1Label);
        labels.add(this.var2Label);
        labels.add(this.var3Label);
        labels.add(this.var4Label);
        for (javax.swing.JLabel panel : labels) {
            if (panel != varIlabel) {
                panel.setOpaque(false);
                panel.setBackground(null);
            }
        }
        varIlabel.setOpaque(true);
        varIlabel.setBackground(Color.lightGray);
        this.userAnswer = varIlabel.getText();
        IsAnswerOfUserIsCorrect();
        return userAnswer;
    }

    private void IsAnswerOfUserIsCorrect() {
        ArrayList<javax.swing.JLabel> labels = new ArrayList<>();
        labels.add(this.var1Label);
        labels.add(this.var2Label);
        labels.add(this.var3Label);
        labels.add(this.var4Label);

        for (javax.swing.JLabel panel : labels) {
            if (panel.getText().equals(correctAnswer)) {
                panel.setOpaque(true);
                panel.setBackground(Color.green);
            } else {
                panel.setOpaque(true);
                panel.setBackground(Color.red);
            }
        }

        if (userAnswer.equals(correctAnswer)) {
            JOptionPane.showMessageDialog(this, "Молодец! Идём к следующей задаче!");
            quastionNumb++;
            for (javax.swing.JLabel panel : labels) {
                panel.setOpaque(false);
                panel.setBackground(null);
            }
            openNextLevel(quastionNumb);
        } else {
            JOptionPane.showMessageDialog(this, "Попробуй ещё раз!");
            for (javax.swing.JLabel panel : labels) {
                panel.setOpaque(false);
                panel.setBackground(null);
            }
            setupQuastion();
        }
    }
    
    private void openNextLevel(int questionNumb) {
    if (questionNumb == 10) {
        if (levelNumb >= 9) {
            String subjectName = switch(subjectNumb) {
                case 1 -> "матстата";
                case 2 -> "линейной алгебры";
                case 3 -> "C/C++";
                default -> "";
            };
            String subjectNameR = switch(subjectNumb) {
                case 1 -> "матстату";
                case 2 -> "линейной алгебре";
                case 3 -> "C/C++";
                default -> "";
            };
            if (levelNumb == 10) updateUserAchievements("Знаток " + subjectName);
            if (levelNumb >= 9) updateUserAchievements("Готов к экзамену по " + subjectNameR);
        }
        if (levelNumb < 10) levelNumb++;
        
        dbManager.editUserOpenedLevels(userId, levelNumb, subjectNumb);
        checkSessionPassedCondition();
        LevelMapJFrame subjectSelectJFrame = new LevelMapJFrame(subjectNumb, userId, dbManager, levelNumb);
        subjectSelectJFrame.setVisible(true);
        dispose();
    } else {
        setupQuastion();
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
        jPanel4 = new javax.swing.JPanel();
        exitDevButton = new javax.swing.JButton();
        nextQuestionDevButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        examDevButton = new javax.swing.JButton();
        backDevButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(700, 410));

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
        var1Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                var1LabelMouseClicked(evt);
            }
        });
        jPanel2.add(var1Label);

        var2Label.setText("");
        var2Label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        var2Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                var2LabelMouseClicked(evt);
            }
        });
        jPanel2.add(var2Label);

        var3Label.setText("");
        var3Label.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        var3Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                var3LabelMouseClicked(evt);
            }
        });
        jPanel2.add(var3Label);

        var4Label.setText("");
        var4Label.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        var4Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                var4LabelMouseClicked(evt);
            }
        });
        jPanel2.add(var4Label);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel11.add(jPanel1);

        jPanel5.setLayout(new java.awt.BorderLayout(0, 5));

        questionTextArea.setEditable(false);
        questionTextArea.setColumns(20);
        questionTextArea.setRows(5);
        questionTextArea.setText("");
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

        jPanel4.setMaximumSize(new java.awt.Dimension(32767, 20));
        jPanel4.setPreferredSize(new java.awt.Dimension(705, 20));
        jPanel4.setLayout(new java.awt.BorderLayout());

        exitDevButton.setBackground(new java.awt.Color(242, 242, 242));
        exitDevButton.setText("       ");
        exitDevButton.setBorder(null);
        exitDevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitDevButtonActionPerformed(evt);
            }
        });
        jPanel4.add(exitDevButton, java.awt.BorderLayout.WEST);

        nextQuestionDevButton.setBackground(new java.awt.Color(242, 242, 242));
        nextQuestionDevButton.setText("      ");
        nextQuestionDevButton.setBorder(null);
        nextQuestionDevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextQuestionDevButtonActionPerformed(evt);
            }
        });
        jPanel4.add(nextQuestionDevButton, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel6.setMaximumSize(new java.awt.Dimension(32767, 20));
        jPanel6.setMinimumSize(new java.awt.Dimension(10, 20));
        jPanel6.setPreferredSize(new java.awt.Dimension(705, 20));
        jPanel6.setLayout(new java.awt.BorderLayout());

        examDevButton.setBackground(new java.awt.Color(242, 242, 242));
        examDevButton.setText("      ");
        examDevButton.setBorder(null);
        examDevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examDevButtonActionPerformed(evt);
            }
        });
        jPanel6.add(examDevButton, java.awt.BorderLayout.EAST);

        backDevButton.setBackground(new java.awt.Color(242, 242, 242));
        backDevButton.setText("       ");
        backDevButton.setBorder(null);
        backDevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backDevButtonActionPerformed(evt);
            }
        });
        jPanel6.add(backDevButton, java.awt.BorderLayout.WEST);

        getContentPane().add(jPanel6, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        JokesJFrame jokesJFrame = new JokesJFrame(levelNumb, subjectNumb, quastionNumb, dbManager, userId);
        jokesJFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void exitDevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitDevButtonActionPerformed
        updateUserAchievements("Шерлок Холмс");
        System.exit(0);
    }//GEN-LAST:event_exitDevButtonActionPerformed

    private void nextQuestionDevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextQuestionDevButtonActionPerformed
        updateUserAchievements("Шерлок Холмс");
        this.quastionNumb = (this.quastionNumb < 10) ? this.quastionNumb++: 10;
        setupQuastion();
    }//GEN-LAST:event_nextQuestionDevButtonActionPerformed

    private void examDevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examDevButtonActionPerformed
        updateUserAchievements("Шерлок Холмс");
        this.levelNumb = 10;
        this.quastionNumb = 0;
        setupQuastion();
    }//GEN-LAST:event_examDevButtonActionPerformed

    private void backDevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backDevButtonActionPerformed
        updateUserAchievements("Шерлок Холмс");
        this.quastionNumb = (this.quastionNumb > 0) ? this.quastionNumb--: 0;
        setupQuastion();
    }//GEN-LAST:event_backDevButtonActionPerformed

    private void var1LabelMouseClicked(java.awt.event.MouseEvent evt) {                                       
        chooseAnswer(var1Label);
    }                                      
	
    private void var2LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_var2LabelMouseClicked
        chooseAnswer(var2Label);
    }//GEN-LAST:event_var2LabelMouseClicked

    private void var3LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_var3LabelMouseClicked
        chooseAnswer(var3Label);
    }//GEN-LAST:event_var3LabelMouseClicked

    private void var4LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_var4LabelMouseClicked
        chooseAnswer(var4Label);
    }//GEN-LAST:event_var4LabelMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backDevButton;
    private javax.swing.JButton examDevButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton exitDevButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextQuestionDevButton;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JTextArea questionTextArea;
    private javax.swing.JLabel var1Label;
    private javax.swing.JLabel var2Label;
    private javax.swing.JLabel var3Label;
    private javax.swing.JLabel var4Label;
    // End of variables declaration//GEN-END:variables
}
