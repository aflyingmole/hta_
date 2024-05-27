package  swingEx01;

import javax.swing.*;
import java.awt.*;

public class JFrameEx06 {
    private JPanel jPanel;
    private JButton button1;

    public static void main(String args[]) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new JFrameEx06().jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}