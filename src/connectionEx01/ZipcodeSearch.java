package connectionEx01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ZipcodeSearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String searchKeyword;
        boolean continueSearch;
        do {
            continueSearch = false; // 검색 계속 여부를 나타내는 변수 초기화

            System.out.print("검색할 주소를 입력하세요: ");
            searchKeyword = sc.nextLine();

            if (searchKeyword.equals("q")) {
                System.out.println("프로그램을 종료합니다");
                break;
            }

            if (!searchKeyword.matches("^[가-힣]*$")) {
                System.out.println("한글로 입력해주세요");
                continueSearch = true; // 검색을 계속하기 위해 변수를 true로 설정
            }

            if (searchKeyword.length() < 2) {
                System.out.println("2자 이상 입력하세요");
                continueSearch = true; // 검색을 계속하기 위해 변수를 true로 설정
            }

            if (continueSearch) {
                continue; // 검색 계속 여부에 따라 다음 반복으로 이동
            }

            try (Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/project", "project", "123456")) {
                String sql = "SELECT * FROM zipcode WHERE sido LIKE ? OR gugun LIKE ? OR dong LIKE ?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, "%" + searchKeyword + "%");
                    pstmt.setString(2, "%" + searchKeyword + "%");
                    pstmt.setString(3, "%" + searchKeyword + "%");

                    try (ResultSet rs = pstmt.executeQuery()) {
                        boolean found = false;
                        while (rs.next()) {
                            String zipcode = rs.getString("zipcode");
                            String sido = rs.getString("sido");
                            String gugun = rs.getString("gugun");
                            String dong = rs.getString("dong");
                            String ri = rs.getString("ri");
                            String bunji = rs.getString("bunji");
                            int seq = rs.getInt("seq");
                            System.out.println("[" + zipcode + "] " + sido + " " + gugun + " " + dong + " " + ri + " " + bunji + " " + seq);
                            found = true;
                        }
                        if (!found) {
                            System.out.println("검색된 결과가 없습니다.");
                        } else {
                            System.out.println("검색 완료");
                        }
                    }
                }
            } catch (SQLException e) {
                System.out.println("데이터베이스 연결 오류: " + e.getMessage());
            }
        } while (true); // 사용자가 "q"를 입력하지 않는 이상 계속해서 반복

        sc.close(); // Scanner 닫기
    }
}
