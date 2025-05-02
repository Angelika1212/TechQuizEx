package ui;
import db.DatabaseManager;
import java.util.List;
import model.Joke;
import ui_components.RoundJButton;

public class JokesJFrame extends javax.swing.JFrame {
    private int subjectNumb;
    private final DatabaseManager dbManager;
    private int levelNumb;
    private int questionNumb;
    private List<Joke> jokes;
    private int userId;

    public JokesJFrame(int levelNumb, int subjectNumb, int questionNumb, DatabaseManager dbManager, int userId) {
        this.dbManager = dbManager;
        this.levelNumb =  levelNumb;
        this.subjectNumb = subjectNumb;
        this.questionNumb = questionNumb;
        this.jokes = dbManager.loadJokes();
        this.userId = userId;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jokesTextArea = new javax.swing.JTextArea();
        jokeNameLabel = new javax.swing.JLabel();
        warningLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jokeImage = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        backToQuizButton = new RoundJButton();
        examButton = new RoundJButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jPanel3.setLayout(new java.awt.BorderLayout(0, 2));

        jokesTextArea.setEditable(false);
        jokesTextArea.setColumns(20);
        jokesTextArea.setRows(5);
        jokesTextArea.setText(jokes.get(0).getDescription());
        jokesTextArea.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jScrollPane1.setViewportView(jokesTextArea);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jokeNameLabel.setText("Минутка юмора:");
        jokeNameLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(jokeNameLabel, java.awt.BorderLayout.PAGE_START);

        warningLabel.setText("⚠️ Предупреждение: Для завершения викторины пройдите экзамен!");
        warningLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.orange, java.awt.Color.orange, java.awt.Color.orange, java.awt.Color.orange));
        jPanel3.add(warningLabel, java.awt.BorderLayout.PAGE_END);

        jPanel1.add(jPanel3);

        jPanel2.setLayout(new java.awt.BorderLayout(0, 10));

        jokeImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jokeImage.setIcon(new javax.swing.ImageIcon(getClass().getResource(jokes.get(0).getImage())));
        jPanel2.add(jokeImage, java.awt.BorderLayout.CENTER);

        jPanel4.setPreferredSize(new java.awt.Dimension(352, 40));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 5));

        backToQuizButton.setText("Вернуться к викторине");
        backToQuizButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        backToQuizButton.setMaximumSize(new java.awt.Dimension(150, 30));
        backToQuizButton.setMinimumSize(new java.awt.Dimension(150, 30));
        backToQuizButton.setPreferredSize(new java.awt.Dimension(150, 30));
        backToQuizButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToQuizButtonActionPerformed(evt);
            }
        });
        jPanel4.add(backToQuizButton);

        examButton.setText("Готов сдать экзамен");
        examButton.setBorder(null);
        examButton.setMaximumSize(new java.awt.Dimension(130, 30));
        examButton.setMinimumSize(new java.awt.Dimension(130, 30));
        examButton.setPreferredSize(new java.awt.Dimension(130, 30));
        examButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examButtonActionPerformed(evt);
            }
        });
        jPanel4.add(examButton);

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        jPanel1.add(jPanel2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        getContentPane().add(filler1, java.awt.BorderLayout.WEST);
        getContentPane().add(filler2, java.awt.BorderLayout.EAST);
        getContentPane().add(filler3, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(filler4, java.awt.BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void examButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examButtonActionPerformed
        QuationJFrame quationJFrame = new QuationJFrame(10, subjectNumb, dbManager, userId);
        quationJFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_examButtonActionPerformed

    private void backToQuizButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToQuizButtonActionPerformed
        QuationJFrame quationJFrame = new QuationJFrame(levelNumb, subjectNumb, questionNumb, dbManager, userId);
        quationJFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_backToQuizButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToQuizButton;
    private javax.swing.JButton examButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jokeImage;
    private javax.swing.JLabel jokeNameLabel;
    private javax.swing.JTextArea jokesTextArea;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables
}
