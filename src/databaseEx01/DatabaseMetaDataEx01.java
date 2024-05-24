package databaseEx01;

import java.sql.*;

public class DatabaseMetaDataEx01 {
    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3306/sample";
        String user = "root";
        String password = "123456";

        Connection conn = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            DatabaseMetaData dmd = conn.getMetaData();

            // DB에 대한 정보
            System.out.println(dmd.getDatabaseProductName());
            System.out.println(dmd.getDatabaseProductVersion());

            // 드라이버
            System.out.println(dmd.getDriverName());
            System.out.println(dmd.getDriverVersion());

            // 접속
            System.out.println(dmd.getURL());
            System.out.println(dmd.getUserName());




        } catch (ClassNotFoundException e) {
            System.out.println("[에러] : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("[에러] : " + e.getMessage());
        } finally {
            if(conn!= null) try { conn.close();} catch(SQLException e){}
        }


    }
}
