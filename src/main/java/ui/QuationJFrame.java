package ui;
import ui_components.RoundJButton;
import ui_components.RoundJTextArea;

public class QuationJFrame extends javax.swing.JFrame {
    public QuationJFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel15 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        questionTextArea = new RoundJTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        jPanel15.setPreferredSize(new java.awt.Dimension(20, 340));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel15, java.awt.BorderLayout.LINE_START);

        jPanel14.setPreferredSize(new java.awt.Dimension(20, 340));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel14, java.awt.BorderLayout.LINE_END);

        jPanel13.setPreferredSize(new java.awt.Dimension(686, 30));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel13, java.awt.BorderLayout.PAGE_END);

        jPanel12.setPreferredSize(new java.awt.Dimension(686, 30));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel12, java.awt.BorderLayout.PAGE_START);

        jPanel11.setLayout(new java.awt.GridLayout(1, 2));

        jPanel1.setLayout(new java.awt.BorderLayout());

        questionLabel.setText("Вопрос №1");
        questionLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        questionLabel.setPreferredSize(new java.awt.Dimension(57, 20));
        jPanel1.add(questionLabel, java.awt.BorderLayout.PAGE_START);

        jPanel3.setPreferredSize(new java.awt.Dimension(323, 40));
        jPanel3.setLayout(new java.awt.CardLayout());

        exitButton.setText("Закончить викторину");
        exitButton.setBorder(null);
        exitButton.setPreferredSize(new java.awt.Dimension(119, 40));
        jPanel3.add(exitButton, "card2");

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.GridLayout(4, 1));

        var1Label.setText("Вариант №1 - 1 кг");
        var1Label.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(var1Label);

        var2Label.setText("Вариант №2 - 0,8 кг");
        var2Label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(var2Label);

        var3Label.setText("Вариант №3 - 5 кг");
        var3Label.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(var3Label);

        var4Label.setText("Вариант №4 - 2 кг");
        var4Label.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(var4Label);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel11.add(jPanel1);

        questionTextArea.setEditable(false);
        questionTextArea.setColumns(20);
        questionTextArea.setRows(5);
        questionTextArea.setText("Идут два верблюда, один красный, другой налево. \nСколько весит кирпич, если ёжику 2 года?");
        questionTextArea.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        questionTextArea.setMargin(new java.awt.Insets(20, 20, 10, 10));
        jScrollPane1.setViewportView(questionTextArea);

        jPanel11.add(jScrollPane1);

        getContentPane().add(jPanel11, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JTextArea questionTextArea;
    private javax.swing.JLabel var1Label;
    private javax.swing.JLabel var2Label;
    private javax.swing.JLabel var3Label;
    private javax.swing.JLabel var4Label;
    // End of variables declaration//GEN-END:variables
}
