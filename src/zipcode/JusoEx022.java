package zipcode;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;

public class JusoEx022 extends JFrame {

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
                    JusoEx022 frame = new JusoEx022();
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
    public JusoEx022() {
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

        JButton btn = new JButton("zipcode search");
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String strDong = textField.getText();
                if (strDong.length() < 2) {
                    textArea.setText("dongname 2 more");

                } else {
                    textArea.setText("");

                    ZipcodeDAO dao = new ZipcodeDAO();

                    ArrayList<ZipcodeTO> addresses = dao.searchZipcode(strDong);

                    for (ZipcodeTO to : addresses) {
                        String zipcode = to.getZipcode();
                        String sido = to.getSido();
                        String gugun = to.getGugun();
                        String dong = to.getDong();
                        String ri = to.getRi();
                        String bunji = to.getBunji();

                        String address = String.format("[%s] %s %s %s %s %s",
                                zipcode, sido, gugun, dong, ri, bunji);
                        textArea.append(address + System.lineSeparator());
                    }
                }
            }
        });
        btn.setBounds(425, 17, 116, 26);
        panel.add(btn);

        textField = new JTextField();
        textField.setBounds(6, 20, 417, 21);
        panel.add(textField);
        textField.setText("plz zipcode");
        textField.setColumns(10);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(16, 112, 548, 500);
        contentPane.add(scrollPane);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
    }

}