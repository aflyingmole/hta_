package connectionEx01;

import java.sql.*;

public class CopyTableData {
    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3306/sample";
        String user = "root";
        String password = "123456";

        String sourceTable = "emp";
        String targetTable = "emp2";

        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            // 동적 SQL 생성
            String sql = "CREATE TABLE " + targetTable + " AS SELECT deptno FROM " + sourceTable;

            stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql);
            System.out.println("[쿼리 성공] " + result);

            // 다른 예제로, PreparedStatement를 사용해 값을 바인딩하는 경우
            String insertSQL = "INSERT INTO " + targetTable + " (deptno) VALUES (?)";
            pstmt = conn.prepareStatement(insertSQL);
            pstmt.setInt(1, 10); // 예제 값

            int insertResult = pstmt.executeUpdate();
            System.out.println("[데이터 삽입 성공] " + insertResult);

        } catch (ClassNotFoundException e) {
            System.out.println("[에러] " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
