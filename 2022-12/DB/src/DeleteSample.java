import java.sql.Connection;

public class DeleteSample {
   public static void main(String[] args) {
      try {

         // データベースと接続する
         Connection con = DBManager.getConnection();

         con.close(); // データベース切断する

      } catch (Exception e) {
         e.printStackTrace();
      }

   }
}
