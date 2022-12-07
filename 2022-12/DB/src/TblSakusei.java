import java.sql.Connection;
import java.sql.Statement;

public class TblSakusei {
   public static void main(String[] args) {
      try {
         
         // データベースと接続する
         Connection con = DBManager.getConnection();
            
         // SQL実行インタフェース取得
         Statement smt = con.createStatement();

      //-------------------------------------------------
         // SQL文
         String sql = "CREATE TABLE ACCOUNT (" +
            " ID INTEGER PRIMARY KEY," +
            " NAME VARCHAR(100)," +
            " EMAIL VARCHAR(100) NOT NULL UNIQUE" +
             ");";
         // SQL実行
         int result = smt.executeUpdate(sql);
         // 結果
         System.out.println("result : " + result);

      //-------------------------------------------------
         
         smt.close();    // SQL実行インタフェースクローズ
         con.close();    // データベース切断する
         
      } catch (Exception e) {
         e.printStackTrace();
      }   

   } 
}
