package connectionEx01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Statement01 {

    public static void main(String[] args) {
        System.out.println("시작");

        String url = "jdbc:mariadb://localhost:3306/sample";
        String user = "root";
        String password = "123456";

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("드라이버 로딩 성공");

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("데이터베이스 연결 성공") ;

            stmt = conn.createStatement();
            stmt.executeUpdate("insert into dept2 values(51,'개발부','서울')");

            System.out.println("입력 완료");
        } catch (ClassNotFoundException e) {
            System.out.println("[에러]" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("[에러]" + e.getMessage());
        } finally {
            if(stmt != null)try{stmt.close();}catch(SQLException e){}
            if(conn != null)try{conn.close();}catch(SQLException e){}
        }
        System.out.println("끝");
    }
}
