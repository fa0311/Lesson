import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.FlowLayout;

class SQLGUI extends JFrame implements ActionListener {
    static Connection con;
    JTextArea inputArea;
    JTextArea outputArea;
    JButton button;

    public static void main(String args[]) {
        new SQLGUI();
    }

    SQLGUI() {
        setTitle("GUI_SQLフレーム");
        setBounds(100, 100, 550, 370);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();

        inputArea = new JTextArea(7, 45);
        inputArea.setLineWrap(true);
        outputArea = new JTextArea(7, 45);
        outputArea.setLineWrap(true);
        button = new JButton("実行");
        button.setPreferredSize(new Dimension(500, 30));
        button.addActionListener(this);

        contentPane.add(new JLabel("SQL入力"));
        contentPane.add(inputArea);
        contentPane.add(button);
        contentPane.add(new JLabel("実行結果"));
        contentPane.add(outputArea);

        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));

        setVisible(true);
        try {
            con = DBManager.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            outputArea.setText(e.toString());
        }
    }

    static String exec(String sql) {
        String output = "";
        try {
            Statement smt = con.createStatement();
            if (sql.toUpperCase().startsWith("SELECT")) {
                ResultSet rs = smt.executeQuery(sql);
                ResultSetMetaData metaData = rs.getMetaData();

                for (int i = 1; i < metaData.getColumnCount() + 1; i++) {
                    output += metaData.getColumnName(i) + ", ";
                }
                output = output.substring(0, output.length() - 2);

                while (rs.next()) {
                    output += "\n";
                    for (int i = 1; i < metaData.getColumnCount() + 1; i++) {
                        output += rs.getString(metaData.getColumnName(i)) + ", ";
                    }
                    output = output.substring(0, output.length() - 2);
                }
            } else {
                output += smt.executeUpdate(sql);
                output += "行に反映しました";
            }
            smt.close();
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
        return output;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            outputArea.setText(exec(inputArea.getText()));
        }
    }
}
