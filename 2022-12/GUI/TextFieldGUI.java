import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// テキストフィールドテスト
class TextFieldGUI extends JFrame implements ActionListener {

    JTextField text1;
    JTextField text2;
    JLabel label;
    JButton button1;
    JButton button2;

    // メイン
    public static void main(String args[]) {
        TextFieldGUI frame = new TextFieldGUI("タイトル");
        frame.setVisible(true);
    }

    // コンストラクタ
    TextFieldGUI(String title) {
        // ウィンドウ設定
        setTitle(title); // タイトル
        setBounds(100, 100, 280, 250); // 表示位置と大きさ (x座標,y座標,幅,高さ)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // パネル（他のコンポーネントの枠組みとして使用）
        JPanel p = new JPanel();

        // コンポーネント作成
        text1 = new JTextField("住所1", 20);
        text2 = new JTextField("住所2", 20);
        button1 = new JButton("取得");
        button2 = new JButton("リセット");
        button1.addActionListener(this); // ボタンへイベントリスナー設定
        button2.addActionListener(this);
        label = new JLabel();

        // パネルにコンポーネントを配置
        p.add(text1);
        p.add(text2);
        p.add(button1);
        p.add(button2);

        // パネル と ラベルをコンテナに配置
        Container contentPane = getContentPane();
        contentPane.add(p, BorderLayout.CENTER); // 中央
        contentPane.add(label, BorderLayout.SOUTH); // 下端

        // 配置確認

    }

    // イベント処理
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            // テキストエリアの内容をラベルに表示する
            label.setText(text1.getText() + text2.getText());
        } else if (e.getSource() == button2) {
            text1.setText("住所1");
            text2.setText("住所2");
            label.setText("");
        }
    }
}
