import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// テキストフィールドテスト
class JankenGUI extends JFrame implements ActionListener {

    JButton startButton;
    JButton gameButton;
    JButton endButton;
    JButton rockButton;
    JButton scissorsButton;
    JButton paperButton;

    JLabel label1;
    JLabel label2;
    JLabel label3;

    int round = -1;
    boolean gameFlag = false;

    Random random = new Random();

    public static void main(String args[]) {
        new JankenGUI();
    }

    JankenGUI() {
        setTitle("じゃんけんゲーム");
        setBounds(100, 100, 280, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel northPanel = new JPanel();
        JPanel southPalel = new JPanel();
        JPanel centerPalel = new JPanel();

        startButton = new JButton("開始");
        gameButton = new JButton("勝負");
        endButton = new JButton("棄権");

        rockButton = new JButton("グー");
        scissorsButton = new JButton("チョキ");
        paperButton = new JButton("パー");

        label1 = new JLabel("じゃんけんゲーム");
        label2 = new JLabel("5回戦勝負");
        label3 = new JLabel("[開始]ボタンを押してください");

        startButton.addActionListener(this);
        gameButton.addActionListener(this);
        endButton.addActionListener(this);
        rockButton.addActionListener(this);
        scissorsButton.addActionListener(this);
        paperButton.addActionListener(this);

        northPanel.add(startButton);
        northPanel.add(gameButton);
        northPanel.add(endButton);
        southPalel.add(rockButton);
        southPalel.add(scissorsButton);
        southPalel.add(paperButton);

        centerPalel.add(label1);
        centerPalel.add(label2);
        centerPalel.add(label3);

        Container contentPane = getContentPane();
        contentPane.add(northPanel, BorderLayout.NORTH);
        contentPane.add(centerPalel, BorderLayout.CENTER);
        contentPane.add(southPalel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            label1.setText("勝負は5回まで。勝った数が多いほうが勝ちです。");
            label2.setText("勝負ボタンを押した後に、");
            label3.setText("あなたの手のボタンを押してください。");
            round = 0;
        } else if (round == -1) {
            label1.setText("[開始]ボタンを押してください");
            label2.setText("");
            label3.setText("");
        } else if (e.getSource() == gameButton) {
            label1.setText("最初はグー...");
            label2.setText("");
            label3.setText("じゃんけん！！！");
            gameFlag = true;
        } else if (!gameFlag) {
            label1.setText("先出です。[勝負]ボタンを押してください。");
            label2.setText("");
            label3.setText("");
        } else if (e.getSource() == endButton) {
            label1.setText("あなたの");
            label2.setText("/");
            label3.setText("またチャレンジしてね！");
            gameFlag = false;
            round = -1;
        } else {
            int player = -1;
            if (e.getSource() == rockButton) {
                label1.setText("あなた：グー");
                player = 0;
            } else if (e.getSource() == scissorsButton) {
                label1.setText("あなた：チョキ");
                player = 1;
            } else if (e.getSource() == paperButton) {
                label1.setText("あなた：パー");
                player = 2;
            }
            int rand = random.nextInt(3);
            if (rand == 0) {
                label2.setText("CPU：グー");
            } else if (rand == 1) {
                label2.setText("CPU：チョキ");
            } else if (rand == 2) {
                label2.setText("CPU：パー");
            }
            if ((player + 1) % 3 == rand) {
                System.out.println("win");
            }
            gameFlag = false;
            round++;
        }
    }
}
