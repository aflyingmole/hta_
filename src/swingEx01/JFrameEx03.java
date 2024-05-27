package swingEx01;

import javax.swing.*;
import java.awt.*;

public class JFrameEx03 extends JFrame {
    public static void main(String[] args) {
        JFrameEx03 frame = new JFrameEx03();

        frame.setVisible(true);
    }
    public JFrameEx03(){
        // setSize(1024, 768);
        // setLocation(100, 100);
        setBounds(100, 100, 1024, 768);

        // 제목
        setTitle("프레임 타이틀");

        // 창닫기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
