package databaseEx01;

import java.sql.*;

public class ResultSetMetaDataEx01 {
    public static void main(String[] args) {

        String url = "jdbc:mariadb://localhost:3306/sample";
        String user = "root";
        String password = "123456";

        Connection conn = null;
        PreparedStatement pstmt = null; // 변수명 수정
        ResultSet rs = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password); // DriverManager 철자 수정

            String sql = "select * from emp";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(rsmd.getColumnCount());

            System.out.println(rsmd.getTableName(1));

            // 번호 - 컬럼의 순서
            for (int i = 1; i <=rsmd.getColumnCount() ; i++) {
                System.out.print(rsmd.getColumnName(i));
                System.out.print(rsmd.getColumnTypeName(i));
                System.out.print(rsmd.getPrecision(i));
                System.out.print(rsmd.getScale(i));
                System.out.print(rsmd.isNullable(i));
                System.out.println();
            }

        } catch (ClassNotFoundException e) {
            System.out.println("[에러] : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("[에러] : " + e.getMessage());
        } finally {
            if(conn!= null) try { conn.close();} catch(SQLException e){}
            if(pstmt!= null) try { pstmt.close();} catch(SQLException e){}
            if(rs!= null) try { rs.close();} catch(SQLException e){}
        }
    }
}
