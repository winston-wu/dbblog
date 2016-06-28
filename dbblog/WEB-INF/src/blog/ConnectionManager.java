package blog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ²�ª��s�u�޲z���O
 * 
 * @author Shinji Miyamoto
 */
public class ConnectionManager {

    /**
     * JDBC�X�ʵ{�������O�W��
     */
    final static String DRIVER = "com.mysql.jdbc.Driver";

    /**
     * ��Ʈw��URL
     */
    final static String URL = "jdbc:mysql://localhost/mydb";

    
    /**
     * ��Ʈw���ϥΪ�
     */
    final static String USER = "root";

    /**
     * ��Ʈw���K�X
     */
    final static String PASS = "hoge";

    /**
     * ���oConncection
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
     * �s�u�T�{����
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
