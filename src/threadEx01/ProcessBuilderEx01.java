package threadEx01;

import java.io.IOException;

public class ProcessBuilderEx01 {
    public static void main(String[] args) {
        // ProcessBuilder => 프로세스 실행 => 프로그램 실행

        ProcessBuilder processBuilder = null;

        try {
            processBuilder = new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
            processBuilder.start();
        } catch (IOException e) {
            System.out.println( "[에러] " + e.getMessage() );
        }
    }
}
