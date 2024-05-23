package connectionEx01;

import java.sql.*;

public class BackUpEx01 {
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
            System.out.println("데이터베이스 연결 성공");

            stmt = conn.createStatement();

            String sql = "insert into emp_10  select * from emp where deptno = 10";

           stmt.executeUpdate(sql);

        } catch (ClassNotFoundException e) {
            System.out.println("[에러]" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("[에러]" + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("[에러]" + e.getMessage());
            }
        }
        System.out.println("끝");
    }
}
