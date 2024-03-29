import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class dbTourokuGUI extends JFrame implements ActionListener {
   static Connection con;
   JTextField inputId;
   JTextField inputName;
   JTextField inputEmail;
   JLabel output;
   JButton registerButton;
   JButton clearButton;

   public static void main(String[] args) {
      dbTourokuGUI frame = new dbTourokuGUI("アカウント登録");
      frame.setVisible(true);
   }

   dbTourokuGUI(String titleName) {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle(titleName);
      setSize(300, 200);

      JPanel p = new JPanel();
      inputId = new JTextField(20);
      inputName = new JTextField(20);
      inputEmail = new JTextField(20);
      registerButton = new JButton("登録");
      clearButton = new JButton("クリア");
      p.add(new JLabel("ID:"));
      p.add(inputId);
      p.add(new JLabel("NAME:"));
      p.add(inputName);
      p.add(new JLabel("EMAIL:"));
      p.add(inputEmail);
      p.add(registerButton);
      p.add(clearButton);

      registerButton.addActionListener(this);
      clearButton.addActionListener(this);

      output = new JLabel();

      Container contentPane = getContentPane();
      contentPane.add(p);
      contentPane.add(output, BorderLayout.SOUTH);

      try {
         con = DBManager.getConnection();
      } catch (Exception e) {
         e.printStackTrace();
         output.setText(e.toString());
      }
   }

   @Override
   public void actionPerformed(ActionEvent event) {
      if (event.getSource() == registerButton) {
         try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO ACCOUNT VALUES(?, ?, ?);");
            ps.setInt(1, Integer.parseInt(inputId.getText()));
            ps.setString(2, inputName.getText());
            ps.setString(3, inputEmail.getText());
            int count = ps.executeUpdate();
            output.setText(count + "行追加しました");
         } catch (Exception e) {
            e.printStackTrace();
            output.setText(e.toString());
         }
      } else if (event.getSource() == clearButton) {
         inputName.setText("");
         inputEmail.setText("");
         output.setText("");
      }
   }
}
