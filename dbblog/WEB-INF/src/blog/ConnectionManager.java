package blog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 簡純的連線管理類別
 * 
 * @author Shinji Miyamoto
 */
public class ConnectionManager {

    /**
     * JDBC驅動程式的類別名稱
     */
    final static String DRIVER = "com.mysql.jdbc.Driver";

    /**
     * 資料庫的URL
     */
    final static String URL = "jdbc:mysql://localhost/mydb";

    
    /**
     * 資料庫的使用者
     */
    final static String USER = "root";

    /**
     * 資料庫的密碼
     */
    final static String PASS = "hoge";

    /**
     * 取得Conncection
     */
    public static Connection getConnection()
            throws SQLException {

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException(
                    "fail to class load : "
                            + e.getMessage());
        }

        Connection con = DriverManager.getConnection(URL,
                USER, PASS);

        return con;
    }

    
    
    
    /**
     * 連線確認測試
     */
    public static void main(String[] args)
            throws SQLException {

        Connection con = getConnection();
        Statement smt = con.createStatement();
        ResultSet rs = smt.executeQuery("select * from account");
        while(rs.next()){
        	String s = "NAME=" + rs.getString("NAME")
        		+ ",MONEY=" + rs.getString("MONEY")
        		;
        	System.out.println(s);
        }
        smt.close();
        con.close();
        System.out.println("END");
    }
}
