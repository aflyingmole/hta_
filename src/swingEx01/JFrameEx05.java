package swingEx01;

import javax.swing.*;
import java.awt.*;

public class JFrameEx05 extends JFrame {
    private JPanel contentPane;

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrameEx05 frame = new JFrameEx05();
                frame.setVisible(true);
            }
        });
    }
    public JFrameEx05() {
    }
}
