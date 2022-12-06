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
class TextFieldTest extends JFrame implements ActionListener {

    JTextField textf;
    JLabel label;
    JButton button;

    // メイン
    public static void main(String args[]) {
        TextFieldTest frame = new TextFieldTest("タイトル");
        frame.setVisible(true);
    }

    // コンストラクタ
    TextFieldTest(String title) {
        // ウィンドウ設定
        setTitle(title); // タイトル
        setBounds(100, 100, 280, 150); // 表示位置と大きさ (x座標,y座標,幅,高さ)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // パネル（他のコンポーネントの枠組みとして使用）
        JPanel p = new JPanel();

        // コンポーネント作成
        textf = new JTextField("文字入力", 20);
        button = new JButton("取得");
        button.addActionListener(this); // ボタンへイベントリスナー設定
        label = new JLabel();

        // パネルにコンポーネントを配置
        p.add(textf);
        p.add(button);

        // パネル と ラベルをコンテナに配置
        Container contentPane = getContentPane();
        contentPane.add(p, BorderLayout.CENTER); // 中央
        contentPane.add(label, BorderLayout.SOUTH); // 下端

        // 配置確認

    }

    // イベント処理
    @Override
    public void actionPerformed(ActionEvent e) {
        // テキストエリアの内容をラベルに表示する
        label.setText(textf.getText());
    }
}
