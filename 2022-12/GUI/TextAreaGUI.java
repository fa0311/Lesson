import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

// テキストフィールドテスト
class TestAreaGUI extends JFrame implements ActionListener {

    JTextArea text1;
    JTextArea text2;
    JButton button1;
    JButton button2;

    // メイン
    public static void main(String args[]) {
        TestAreaGUI frame = new TestAreaGUI("タイトル");
        frame.setVisible(true);
    }

    // コンストラクタ
    TestAreaGUI(String title) {
        // ウィンドウ設定
        setTitle(title); // タイトル
        setBounds(100, 100, 280, 250); // 表示位置と大きさ (x座標,y座標,幅,高さ)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // パネル（他のコンポーネントの枠組みとして使用）
        JPanel p = new JPanel();

        // コンポーネント作成
        text1 = new JTextArea(7, 10);
        text2 = new JTextArea(7, 10);
        text1.setLineWrap(true);
        text2.setLineWrap(true);
        text2.setBackground(Color.decode("#A3A3A3"));
        text2.setEditable(false);
        button1 = new JButton("全て取得");
        button2 = new JButton("20文字取得");
        button1.addActionListener(this); // ボタンへイベントリスナー設定
        button2.addActionListener(this);

        // パネルにコンポーネントを配置
        p.add(text1);
        p.add(text2);
        p.add(button1);
        p.add(button2);

        // パネル と ラベルをコンテナに配置
        Container contentPane = getContentPane();
        contentPane.add(p, BorderLayout.CENTER); // 中央

        // 配置確認

    }

    // イベント処理
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            text2.setText(text1.getText());
        } else if (e.getSource() == button2) {
            if (text1.getText().length() > 20) {
                text2.setText(text1.getText().substring(0, 20));
            } else {
                text2.setText(text1.getText());
            }
        }
    }
}
