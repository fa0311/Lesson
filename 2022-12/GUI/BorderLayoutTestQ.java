import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.JButton;
import java.awt.FlowLayout;

class FlowLayoutTestQ extends JFrame {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 200);
        Container c = f.getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton b1 = new JButton("YES");
        JButton b2 = new JButton("NO");
        c.add(b1);
        c.add(b2);
        f.setVisible(true);
    }
}