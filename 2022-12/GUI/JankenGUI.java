import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

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
    int win = 0;
    boolean gameFlag = false;

    Random random = new Random();

    public static void main(String args[]) {
        new JankenGUI();
    }

    JankenGUI() {
        setTitle("じゃんけんゲーム");
        setBounds(100, 100, 350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startButton = new JButton("開始");
        gameButton = new JButton("勝負");
        endButton = new JButton("棄権");
        rockButton = new JButton("グー");
        scissorsButton = new JButton("チョキ");
        paperButton = new JButton("パー");
        setButton(startButton);
        setButton(gameButton);
        setButton(endButton);
        setButton(rockButton);
        setButton(scissorsButton);
        setButton(paperButton);

        label1 = new JLabel("じゃんけんゲーム");
        label2 = new JLabel("5回戦勝負");
        label3 = new JLabel("[開始]ボタンを押してください");
        label1.setPreferredSize(new Dimension(300, 35));
        label2.setPreferredSize(new Dimension(300, 35));
        label3.setPreferredSize(new Dimension(300, 35));

        JPanel northPanel = new JPanel();
        JPanel southPalel = new JPanel();
        JPanel centerPalel = new JPanel();

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

    public void setButton(JButton button) {
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(100, 35));
    }

    // 結果
    public void result() {
        if ((float) round / 2 < win) {
            label1.setText("あなたの勝ち！");
            label3.setText("おめでとう！");
        } else if ((float) round / 2 > win) {
            label1.setText("あなたの負け...");
            label3.setText("またチャレンジしてね！");
        } else {
            label1.setText("引き分け");
            label3.setText("またチャレンジしてね！");
        }
        label2.setText(win + "/" + round);
        gameFlag = false;
        round = -1;
    }

    // 数値を分かりやすい文字に変換
    public String toText(int i) {
        switch (i) {
            case 0:
                return "グー";
            case 1:
                return "チョキ";
            case 2:
                return "パー";
            default:
                throw new IllegalArgumentException();
        }
    }

    // ボタンを数値に変換
    public int toInt(JButton button) {
        if (button == rockButton) {
            return 0;
        } else if (button == scissorsButton) {
            return 1;
        } else if (button == paperButton) {
            return 2;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            label1.setText("勝負は5回まで。勝った数が多いほうが勝ちです。");
            label2.setText("勝負ボタンを押した後に、");
            label3.setText("あなたの手のボタンを押してください。");
            round = 0;
            win = 0;
        } else if (round == -1) {
            label1.setText("[開始]ボタンを押してください");
            label2.setText("");
            label3.setText("");
        } else if (e.getSource() == gameButton) {
            label1.setText("最初はグー...");
            label2.setText("");
            label3.setText("じゃんけん！！！");
            gameFlag = true;
        } else if (e.getSource() == endButton) {
            result();
        } else if (!gameFlag) {
            label1.setText("先出です。[勝負]ボタンを押してください。");
            label2.setText("");
            label3.setText("");
        } else {
            int player = toInt((JButton) e.getSource());
            label1.setText("あなた: " + toText(player));
            int rand = random.nextInt(3);
            label2.setText("CPU：" + toText(rand));
            if ((player + 1) % 3 == rand) {
                win++;
            }
            gameFlag = false;
            round++;
            label3.setText("あと" + (5 - round) + "回");
            if (round == 5) {
                result();
            }
        }
    }
}
