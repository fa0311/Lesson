import java.sql.Connection;
import java.sql.Statement;

public class InsertSample {
   public static void main(String[] args) {
      try {
         
         // データベースと接続する
         Connection con = DBManager.getConnection();
            
         // SQL実行インタフェース取得
         Statement smt = con.createStatement();

      //-------------------------------------------------
         // SQL文
         String sql = "INSERT INTO ACCOUNT "
         +" (ID, NAME, EMAIL) VALUES (5, 'ボビー', 'bobby@email.adrs')";
         // SQL実行
         int count = smt.executeUpdate(sql);
         // 登録更新行数表示
         System.out.println("Insert count : " + count);

      //-------------------------------------------------
         
         smt.close();    // SQL実行インタフェースクローズ
         con.close();    // データベース切断する
         
      } catch (Exception e) {
         e.printStackTrace();
      }   

   } 
}
