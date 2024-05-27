package swingEx01;

import javax.swing.*;
import java.awt.*;

public class JFrameEx04 extends JFrame {
    private JPanel contentPane;

    public static void main(String[] args) {

        // 프로그램 시작
        JFrameEx04 frame = new JFrameEx04();
        frame.setVisible(true);
    }

    public JFrameEx04() {
        // JFrame 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1024, 768);

        // 컴포넌트가 들어갈 공간
        contentPane = new JPanel();
        contentPane.setBackground(Color.PINK);

        // null- absolute layout
        contentPane.setLayout(null);
        
        // 입력
        JButton btn1 = new JButton("button");
        btn1.setBounds(10,10,100,25);
        contentPane.add(btn1);

        JButton btn2 = new JButton("btn");
        btn2.setBounds(200,10,100,25);
        contentPane.add(btn2);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\jhta\\Downloads\\hta_\\17c6b22881ca9dc077a652b3a2627aed26397d82c8691bdabf557d1536959d9c.png");
        JButton btn3 = new JButton(imageIcon);
        btn3.setBounds(500,10,200,200);
        contentPane.add(btn3);



        // JFrame Panel 부착
        setContentPane(contentPane);
    }
}
