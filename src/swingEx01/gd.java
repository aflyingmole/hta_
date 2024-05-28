package swingEx01;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class gd extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField1;
    private JLabel lbl1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    gd frame = new gd();
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
    public gd() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField1 = new JTextField();
        textField1.setText("hong gil dong");
        textField1.setBounds(12, 10, 560, 21);
        contentPane.add(textField1);
        textField1.setColumns(10);

        JButton btn1 = new JButton("클릭해주세요");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btn1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String inputText = textField1.getText();
                String result = capitalizeFirstLetter(inputText);
                lbl1.setText(result);
            }
        });
        btn1.setBounds(12, 41, 560, 23);
        contentPane.add(btn1);

        lbl1 = new JLabel("New label");
        lbl1.setBounds(12, 74, 560, 30);
        contentPane.add(lbl1);
    }

    private String capitalizeFirstLetter(String input) {
        StringBuilder output = new StringBuilder();
        boolean capitalizeNext = true;

        for (char c : input.toCharArray()) {
            if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            } else if (capitalizeNext) {
                output.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                output.append(Character.toLowerCase(c));
            }
        }

        return output.toString();
    }
}
