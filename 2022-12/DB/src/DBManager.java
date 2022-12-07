import java.sql.Connection;
import java.sql.DriverManager;


public class DBManager {
    static final String JDBC_DRIVER = "org.h2.Driver";
    //static final String DB_URL = "jdbc:h2:~/test";
    //static final String DB_URL = "jdbc:h2:file:C:/data/example";   //組み込みモード
    static final String DB_URL = "jdbc:hsqldb:hsql://localhost/";      // サーバーモード

    // Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    public static Connection getConnection() {
        Connection con = null;
        try{
            // hsqldbのJDBCドライバを指定する
            // (クラス名を指定してクラスをロードする。利用するJDBCの種類によって異なる)
            Class.forName(JDBC_DRIVER);
            // データベースに接続する
            con = DriverManager.getConnection(
                             DB_URL,	// URL
                             USER,		// ユーザー名
                             PASS);		// パスワード
            // データベースコネクションオブジェクトを返す
            return con;
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return con;
    }
}

class DBManagerTest{  
    public static void main(String[] args) throws Exception {
        // データベースと接続する
        DBManager db = new DBManager();
        Connection con = db.getConnection();
        // データベースのコネクション内容を表示
        System.out.println("con = " + con);
        // データベースを切断する(必ず行う)
        con.close();
    }
}
