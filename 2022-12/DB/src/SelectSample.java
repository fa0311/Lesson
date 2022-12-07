import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class SelectSample {
   public static void main(String[] args) {
      try {
         
         // データベースと接続する
         Connection con = DBManager.getConnection();
            
         // SQL実行インタフェース取得
         Statement smt = con.createStatement();

      //-------------------------------------------------
         String sql = "SELECT * FROM ACCOUNT;";
         // 検索SQL実行
         ResultSet rs = smt.executeQuery(sql);

         // テーブル情報取得
         ResultSetMetaData metaData = rs.getMetaData();  //取得開始

         // カラム名を表示
         int columnCount = metaData.getColumnCount();    // 列数を取得
         for(int i = 0; i < columnCount; i++){
            if( 0 < i ) { System.out.print(", "); };
            System.out.print(metaData.getColumnName(i+1));  // 列名を取得して表示
         }
         System.out.println();		// 改行

         // 検索結果を全行取り出して表示
         while(rs.next()){
            // １行ずつ表示する 列名を指定して、型にあわせてデータを取得
            System.out.println("ID = " + rs.getInt("ID")
                           + ", NAME = " + rs.getString("NAME")
                           + ", EMAIL = " + rs.getString("EMAIL"));
         }

         rs.close(); //取得終了
      //-------------------------------------------------
         
         smt.close();    // SQL実行インタフェースクローズ
         con.close();    // データベース切断する
         
      } catch (Exception e) {
         e.printStackTrace();
      }   

   } 
}
