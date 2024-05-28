package zipcode;

import java.sql.*;
import java.util.ArrayList;

public class ZipcodeDAO {
    private Connection conn;

    public ZipcodeDAO() {
        String url = "jdbc:mariadb://localhost:3306/project";
        String user = "project";
        String password = "123456";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            this.conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("[에러] : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("[에러] : " + e.getMessage());

        }
    }

    // select
    public ArrayList<ZipcodeTO> searchZipcode(String strDong) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        ArrayList<ZipcodeTO> addresses = new ArrayList<>();

        try {
            String sql = "select zipcode, sido , gugun, dong, ri, bunji from zipcode where dong like ?";
            pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, strDong + "%");

            rs = pstmt.executeQuery();
            while (rs.next()) {
                ZipcodeTO to = new ZipcodeTO();
                to.setZipcode(rs.getString("zipcode"));
                to.setSido(rs.getString("sido"));
                to.setGugun(rs.getString("gugun"));
                to.setDong(rs.getString("dong"));
                to.setRi(rs.getString("ri"));
                to.setBunji(rs.getString("bunji"));

                addresses.add(to);
            }
        } catch (SQLException e) {
            System.out.println("[에러] : " + e.getMessage());
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
            }
            if (pstmt != null) try {
                pstmt.close();
            } catch (SQLException e) {
            }
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
            }
        }
        return addresses;
    }
}
