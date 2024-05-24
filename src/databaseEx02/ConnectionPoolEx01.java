package databaseEx02;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionPoolEx01 {
    public static void main(String[] args) {

        System.out.println("시작");

        HikariDataSource dataSource = null;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;



        try {
            dataSource = new HikariDataSource();

            dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mariadb://localhost:3306/sample");
            dataSource.setUsername("root");
            dataSource.setPassword("123456");
            conn = dataSource.getConnection();

            String sql = "select version()";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            if(rs.next()){
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("[에러] : " + e.getMessage());
        } finally {
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
            }
            if (pstmt != null) try {
                pstmt.close();
            } catch (SQLException e) {
            }
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
            }

            if(dataSource != null) dataSource.close();
        }
        System.out.println("끝");

    }
}
