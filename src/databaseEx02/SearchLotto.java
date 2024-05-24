package databaseEx02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class SearchLotto {

    public static void main(String[] args) {
        Workbook workBook = null;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Excel 파일 열기
            workBook = Workbook.getWorkbook(new FileInputStream("C:\\Users\\jhta\\Downloads\\hta_\\lotto(1119).xls"));
            Sheet sheet = workBook.getSheet(0);

            // MariaDB JDBC 드라이버 로드
            Class.forName("org.mariadb.jdbc.Driver");

            // 데이터베이스 연결 정보
            String url = "jdbc:mariadb://localhost:3306/sample";
            String user = "root";
            String password = "123456";

            // 데이터베이스 연결
            conn = DriverManager.getConnection(url, user, password);

            // PreparedStatement 생성
            String insertSQL = "INSERT INTO lottotbl (seq, n1, n2, n3, n4, n5, n6, n7, wdate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertSQL);

            // Excel 파일 읽기
            for (int row = sheet.getRows(); row >= 4; row--) {
                Cell turn = sheet.getCell(2 - 1, row - 1);
                Cell num1 = sheet.getCell(14 - 1, row - 1);
                Cell num2 = sheet.getCell(15 - 1, row - 1);
                Cell num3 = sheet.getCell(16 - 1, row - 1);
                Cell num4 = sheet.getCell(17 - 1, row - 1);
                Cell num5 = sheet.getCell(18 - 1, row - 1);
                Cell num6 = sheet.getCell(19 - 1, row - 1);
                Cell num7 = sheet.getCell(20 - 1, row - 1);
                Cell wdate = sheet.getCell(3 - 1, row - 1);

                // 데이터베이스에 삽입
                pstmt.setInt(1, Integer.parseInt(turn.getContents())); // seq
                pstmt.setInt(2, Integer.parseInt(num1.getContents())); // n1
                pstmt.setInt(3, Integer.parseInt(num2.getContents())); // n2
                pstmt.setInt(4, Integer.parseInt(num3.getContents())); // n3
                pstmt.setInt(5, Integer.parseInt(num4.getContents())); // n4
                pstmt.setInt(6, Integer.parseInt(num5.getContents())); // n5
                pstmt.setInt(7, Integer.parseInt(num6.getContents())); // n6
                pstmt.setInt(8, Integer.parseInt(num7.getContents())); // n7 (보너스 번호)
                pstmt.setString(9, wdate.getContents()); // wdate

                pstmt.executeUpdate();
            }

            System.out.println("데이터베이스에 데이터를 성공적으로 삽입했습니다.");

        } catch (BiffException | ClassNotFoundException | SQLException e) {
            System.out.println("[에러] " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("[에러] 파일을 찾을 수 없습니다: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[에러] IO 예외 발생: " + e.getMessage());
        } finally {
            // 자원 해제
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
            if (workBook != null) {
                workBook.close();
            }
        }
    }
}
