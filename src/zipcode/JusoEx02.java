package zipcode;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JusoEx02 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JusoEx02 frame = new JusoEx02();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public JusoEx02() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uC6B0\uD3B8\uBC88\uD638 \uAC80\uC0C9\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(16, 23, 548, 69);
        contentPane.add(panel);
        panel.setLayout(null);

        JButton btn = new JButton("우편번호 검색");
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String strDong = textField.getText();
                if(strDong.length()<2) {
                    textArea.setText("동이름을 2자 이상 입력");

                }else {
                    textArea.setText("");

                    String url = "jdbc:mariadb://localhost:3306/project";
                    String user = "project";
                    String password = "123456";

                    Connection conn = null;
                    PreparedStatement pstmt = null;
                    ResultSet rs = null;

                    try {
                        Class.forName("org.mariadb.jdbc.Driver");
                        conn = DriverManager.getConnection(url, user, password);

                        String sql = "SELECT zipcode, sido, gugun, dong, ri, bunji FROM zipcode WHERE dong LIKE ?";
                        pstmt = conn.prepareStatement(sql);
                        pstmt.setString(1, strDong + "%");

                        rs = pstmt.executeQuery();
                        while(rs.next()) {
                            //후처리
                            String zipcode = rs.getString("zipcode");
                            String sido = rs.getString("sido");
                            String gugun = rs.getString("gugun");
                            String dong = rs.getString("dong");
                            String ri = rs.getString("ri");
                            String bunji = rs.getString("bunji");

                            String address = String.format ("[%s] %s %s %s %s %s",
                                    zipcode, sido, gugun, dong, ri, bunji );
                            textArea.append(address+System.lineSeparator());
                        }
                    } catch (ClassNotFoundException e1) {
                        // TODO Auto-generated catch block
                        System.out.println("[에러]" + e1.getMessage());
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        System.out.println("[에러]" + e1.getMessage());
                    }finally {
                        if (rs != null) try { rs.close(); } catch (SQLException e1) {}
                        if (pstmt != null) try { pstmt.close(); } catch (SQLException e1) {}
                        if (conn != null) try { conn.close(); } catch (SQLException e1) {}
                    }


                }
            }
        });

        btn.setBounds(425, 17, 116, 26);
        panel.add(btn);

        textField = new JTextField();
        textField.setBounds(6, 20, 417, 21);
        panel.add(textField);
        textField.setText("우편번호를 입력하세요.");
        textField.setColumns(10);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(16, 112, 548, 500);
        contentPane.add(scrollPane);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
    }

}