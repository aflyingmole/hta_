package pack6;

import javax.swing.JOptionPane;

public class hi {
    public static void main(String[] args) {
        // 사용자로부터 단 수 입력 받기
        String input = JOptionPane.showInputDialog("구구단을 출력할 단 수를 입력하세요:");
        int dan = Integer.parseInt(input);

        // 구구단 출력
        System.out.println(dan + "단의 결과입니다.");
        for (int i = 1; i <= 9; i++) {
            System.out.println(dan + " x " + i + " = " + (dan * i));
        }
    }
}
