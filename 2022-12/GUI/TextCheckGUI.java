import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

// テキストフィールドテスト
class TextCheckGUI extends JFrame implements ActionListener {

    JTextArea text1;
    JTextField text2;
    JLabel label1;
    JLabel label2;
    JButton button1;

    // メイン
    public static void main(String args[]) {
        TextCheckGUI frame = new TextCheckGUI("タイトル");
        frame.setVisible(true);
    }

    // コンストラクタ
    TextCheckGUI(String title) {
        // ウィンドウ設定
        setTitle(title); // タイトル
        setBounds(100, 100, 280, 250); // 表示位置と大きさ (x座標,y座標,幅,高さ)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // パネル（他のコンポーネントの枠組みとして使用）
        JPanel p = new JPanel();

        // コンポーネント作成
        text1 = new JTextArea(7, 22);
        text2 = new JTextField(10);
        button1 = new JButton("文字数チェック");
        button1.setPreferredSize(new Dimension(240, 25));
        button1.addActionListener(this); // ボタンへイベントリスナー設定
        label1 = new JLabel("入力制限文字数");
        label2 = new JLabel();

        // パネルにコンポーネントを配置
        p.add(text1);
        p.add(label1);
        p.add(text2);
        p.add(button1);
        p.add(label2);

        // パネル と ラベルをコンテナに配置
        Container contentPane = getContentPane();
        contentPane.add(p, BorderLayout.CENTER); // 中央

        // 配置確認

    }

    // イベント処理
    @Override
    public void actionPerformed(ActionEvent e) {
        String output = "文字数:" + text1.getText().length();
        int limit = -1;
        if (!text2.getText().isEmpty()) {
            limit = Integer.parseInt(text2.getText().toString());
        }
        if (limit >= 0 && text1.getText().length() > limit) {
            output += " 文字オーバー:";
            output += text1.getText().length() - limit;
        }
        label2.setText(output);
    }
}
