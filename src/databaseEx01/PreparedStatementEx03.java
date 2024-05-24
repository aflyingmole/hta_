package databaseEx01;

import java.sql.*;

public class PreparedStatementEx03 {
    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3306/sample";
        String user = "root";
        String password = "123456";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            String sql = "select deptno, dname, loc from dept2 where dname=?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "개발부");

            rs = pstmt.executeQuery();
            while (rs.next()) {
                String result = String.format("%s %s %s", rs.getString("deptno"), rs.getString("dname"), rs.getString("loc"));
                System.out.println(result);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("[에러] : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("[에러] : " + e.getMessage());
        } finally {
            if (pstmt != null) try {
                pstmt.close();
            } catch (SQLException e) {
            }
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
            }
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
            }
        }
    }
}
