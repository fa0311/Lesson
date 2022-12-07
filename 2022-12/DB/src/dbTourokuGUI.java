import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;


public class dbTourokuGUI extends JFrame implements ActionListener {
   public static void main(String[] args) {
      dbTourokuGUI frame = new dbTourokuGUI("アカウント登録");
      frame.setVisible(true);
   } 

   dbTourokuGUI(String titleName){
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle(titleName);
      setSize(600, 400);   // サイズは調整すること

      // 画面を作成する      






   }

   @Override
   public void actionPerformed(ActionEvent e) {
      // ボタンが押されたらDBに登録をする



      

   }
}
