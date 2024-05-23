package connectionEx01;

import java.sql.*;
import java.util.Date;

public class StatementTest2 {
    public static void main(String[] args) {
        System.out.println("시작");

        String url = "jdbc:mariadb://localhost:3306/sample";
        String user = "root";
        String password = "123456";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("드라이버 로딩 성공");

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("데이터베이스 연결 성공") ;

            stmt = conn.createStatement();

            String sql = String.format("SELECT empno, ename, sal, hiredate FROM emp ");
            rs = stmt.executeQuery(sql);

            while(rs.next()) {
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                int sal = rs.getInt("sal");
                Date hiredate = rs.getDate("hiredate");

                String formattedHiredate = hiredate.toString().replace("-", "/");



                System.out.printf("사원번호: %d, 사원이름: %s, 급여: %d,입사일자: %s%n", empno, ename, sal, formattedHiredate);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("[에러]" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("[에러]" + e.getMessage());
        } finally {
            if(rs != null)try{rs.close();}catch(SQLException e){}
            if(stmt != null)try{stmt.close();}catch(SQLException e){}
            if(conn != null)try{conn.close();}catch(SQLException e){}
        }
        System.out.println("끝");
    }
}