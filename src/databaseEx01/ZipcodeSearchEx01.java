package databaseEx01;

import java.sql.*;

public class ZipcodeSearchEx01 {
    public static void main(String[] args) {

        // 입력값 검사
        if (args.length != 1){
            // 비정상 입력
            System.out.println("[실행방법] java ZipcodeSearchEx 동이름");
            System.exit(0);
        }
        // 정상 입력

        String url = "jdbc:mariadb://localhost:3306/project";
        String user = "project";
        String password = "123456";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            stmt = conn.createStatement();

            String sql = "";
            rs = stmt.executeQuery(sql);
            while(rs.next()){

            }
        } catch (ClassNotFoundException e) {
            System.out.println("[에러] : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("[에러] : " + e.getMessage());
        } finally {
            if(rs!= null) try { rs.close();} catch(SQLException e){}
            if(stmt!= null) try { stmt.close();} catch(SQLException e){}
            if(conn!= null) try { conn.close();} catch(SQLException e){}
        }
    }
}
