package swingEx01;

import javax.swing.*;

public class JFrameEx01 {
    public static void main(String[] args) {

        // JFrame
        // has ~ a  : 인스턴스
        // is ~ a   : 상속

        JFrame frame = new JFrame();

        // 크기와 위치
        frame.setSize(1024, 768);
        frame.setLocation(100, 100);

        frame.setVisible(true);
    }
}
