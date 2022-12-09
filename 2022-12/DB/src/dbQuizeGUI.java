import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class dbQuizeGUI extends JFrame implements ActionListener {
    static Connection con;
    JRadioButton radioButton1;
    JRadioButton radioButton2;
    JTextArea quizField;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JButton starButton;

    int quizCount = -1;
    int correctCount = 0;
    int anser = -1;
    boolean state = false;
    int[] quizIdList = new int[5];

    public static void main(String[] args) {
        new dbQuizeGUI();
    }

    dbQuizeGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("一問一答");
        setSize(300, 370);

        radioButton1 = new JRadioButton("順番", true);
        radioButton2 = new JRadioButton("ランダム");
        radioButton2.isSelected();
        ButtonGroup modeButton = new ButtonGroup();
        modeButton.add(radioButton1);
        modeButton.add(radioButton2);

        quizField = new JTextArea(5, 24);
        quizField.setLineWrap(true);
        quizField.setEditable(false);
        quizField.setText(quizIdList.length + "問、出題します");
        JScrollPane scrollpane = new JScrollPane(quizField,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        button1 = new JButton("ア");
        button2 = new JButton("イ");
        button3 = new JButton("ウ");
        button4 = new JButton("エ");
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        starButton = new JButton("開始");

        JPanel p1 = new JPanel();

        p1.add(radioButton1);
        p1.add(radioButton2);

        label1.setPreferredSize(new Dimension(200, 20));
        label2.setPreferredSize(new Dimension(200, 20));
        label3.setPreferredSize(new Dimension(200, 20));
        label4.setPreferredSize(new Dimension(200, 20));

        JPanel header = new JPanel();
        header.add(new JLabel("JAVAクイズ"));
        header.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel body = new JPanel();
        body.add(p1);
        body.add(scrollpane);
        body.add(button1);
        body.add(label1);
        body.add(button2);
        body.add(label2);
        body.add(button3);
        body.add(label3);
        body.add(button4);
        body.add(label4);
        body.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel footer = new JPanel();
        footer.add(starButton);
        footer.setLayout(new FlowLayout(FlowLayout.CENTER));

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        starButton.addActionListener(this);

        Container contentPane = getContentPane();
        contentPane.add(header, BorderLayout.NORTH);
        contentPane.add(body, BorderLayout.CENTER);
        contentPane.add(footer, BorderLayout.SOUTH);
        setVisible(true);

        buttonChangeEnable(false);

        try {
            con = DBManager.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            quizField.setText(e.toString());
        }
    }

    public void updateQuizIdList() {
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT ID FROM DB_QUIZE LIMIT 5;"); // ORDER BY RAND()
            int i = 0;
            while (rs.next()) {
                quizIdList[i] = rs.getInt("ID");
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            quizField.setText(e.toString());
        }
    }

    public void buttonChangeEnable(boolean b) {
        radioButton1.setEnabled(!b);
        radioButton2.setEnabled(!b);
        button1.setEnabled(b);
        button2.setEnabled(b);
        button3.setEnabled(b);
        button4.setEnabled(b);
    }

    public void showQuiz() {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM DB_QUIZE WHERE ID = ?;");
            ps.setInt(1, quizIdList[quizCount]);
            ResultSet rs = ps.executeQuery();
            rs.next();
            quizField.setText(rs.getString("QUESTION"));
            label1.setText(rs.getString("CHOICES1"));
            label2.setText(rs.getString("CHOICES2"));
            label3.setText(rs.getString("CHOICES3"));
            label4.setText(rs.getString("CHOICES4"));
            anser = rs.getInt("ANSWER");
        } catch (Exception e) {
            e.printStackTrace();
            quizField.setText(e.toString());
        }
    }

    public void showResult() {
        quizField.setText(quizCount + "問中、" + correctCount + "問正解しました");
        starButton.setText("もう一度");
        buttonChangeEnable(false);
        quizCount = -1;
    }

    public int getButtonId(JButton button) {
        if (button == button1) {
            return 1;
        } else if (button == button2) {
            return 2;
        } else if (button == button3) {
            return 3;
        } else if (button == button4) {
            return 4;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (quizCount == -1) {
            quizCount = 0;
            correctCount = 0;
            state = false;
            updateQuizIdList();
        }
        if (event.getSource() == starButton) {
            if (quizIdList[quizCount] == 0) {
                showResult();
            } else if (state) {
                quizCount--;
                showResult();
            } else {
                state = true;
                buttonChangeEnable(true);
                showQuiz();
                quizCount++;
                starButton.setText("終了");
            }
        } else if (anser != -1 && getButtonId((JButton) event.getSource()) == anser) {
            quizField.setText("正解です");
            starButton.setText("次の問題へ");
            buttonChangeEnable(false);
            state = false;
        } else {
            quizField.setText("違います");
            starButton.setText("次の問題へ");
            buttonChangeEnable(false);
            state = false;
        }
    }
}
