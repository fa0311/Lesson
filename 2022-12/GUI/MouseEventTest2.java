import java.awt.Container;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JFrame;

class MouseEventTest2 extends JFrame implements MouseListener {
    Container c;
    boolean isWhite = false;

    public MouseEventTest2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Mouse Event Test");
        setSize(400, 300);
        c = getContentPane();
        c.setBackground(Color.black);
        addMouseListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        c.setBackground((isWhite = !isWhite) ? Color.white : Color.black);
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public static void main(String[] args) {
        MouseEventTest2 met = new MouseEventTest2();
        met.setVisible(true);
    }
}
