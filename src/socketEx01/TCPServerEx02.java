package socketEx01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerEx02 {
    public static void main(String[] args) {

        //ServerSocket - 포트를 열고 대기하는 프로그램

        ServerSocket serverSocket = null;
        Socket socket = null;

        BufferedWriter bw = null;

        try {
            serverSocket = new ServerSocket(7777);
            System.out.println("서버가 준비되었습니다.");

            socket = serverSocket.accept();
            System.out.println("클라이언트가 연결되었습니다.");

            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
            bw.write("이유현" + System.lineSeparator());
            bw.write("이유현2" + System.lineSeparator());
            bw.write("이유현3" + System.lineSeparator());
            bw.write("이유현4" + System.lineSeparator());
            bw.write("이유현5" + System.lineSeparator());
            bw.write("이유현6" + System.lineSeparator());
            bw.write("이유현7" + System.lineSeparator());
            bw.write("이유현8" + System.lineSeparator());

            System.out.println("전송 완료");

        } catch (IOException e) {
            System.out.println("[에러]" + e.getMessage());
        } finally {
            if(bw != null)try{bw.close();}catch (IOException e){}

            if(socket != null)try{socket.close();}catch (IOException e){}
            if(serverSocket != null)try{serverSocket.close();}catch (IOException e){}
        }
    }
}
