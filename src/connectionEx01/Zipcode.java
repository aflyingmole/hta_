package connectionEx01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Zipcode {

    public static void main(String[] args) {
        // CSV 파일 경로
        String csvFile = "C:\\Users\\jhta\\Downloads\\hta_\\zipcode_seoul_utf8_type.csv";
        String line;
        String csvSplitBy = ",";

        // 데이터베이스 연결 정보
        String url = "jdbc:mariadb://localhost:3306/project";
        String user = "project";
        String password = "123456";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // MariaDB JDBC 드라이버 로드
            Class.forName("org.mariadb.jdbc.Driver");
            // 데이터베이스 연결
            conn = DriverManager.getConnection(url, user, password);

            // PreparedStatement 생성
            String insertSQL = "INSERT INTO zipcode (zipcode, sido, gugun, dong, ri, bunji, seq) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertSQL);

            // CSV 파일 읽기
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // CSV 파일의 첫 줄은 헤더일 수 있으므로 건너뛰기
                if (line.startsWith("zipcode")) {
                    continue;
                }

                // CSV 한 줄을 쉼표로 분리
                String[] data = line.split(csvSplitBy);

                // 데이터베이스에 삽입
                pstmt.setString(1, data[0]); // zipcode
                pstmt.setString(2, data[1]); // sido
                pstmt.setString(3, data[2]); // gugun
                pstmt.setString(4, data[3]); // dong
                pstmt.setString(5, data[4]); // ri
                pstmt.setString(6, data[5]); // bunji
                pstmt.setString(7, data[6]); // seq

                pstmt.executeUpdate();
            }
            br.close();

            System.out.println("CSV 파일의 데이터를 데이터베이스에 성공적으로 삽입했습니다.");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 자원 해제
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
}