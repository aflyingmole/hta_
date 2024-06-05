package socketEx01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPClientEx03 {

    public static void main(String[] args) {

        //ServerSocket = 포트를 열고 대기하는 프로그램

        ServerSocket serverSocket = null;
        Socket socket = null;


        BufferedWriter bw = null;

        try {
            serverSocket = new ServerSocket( 7777 );
            System.out.println("서버가 준비되었습니다");

            socket = serverSocket.accept();
            System.out.println("클라이언트와 연결되었습니다.");

            //소켓에 다국어를 보낼수있게끔 가속화
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));

            // 일반적인 출력
            //bw.write("안녕 서버 1" + System.lineSeparator());
            //bw.write("안녕 서버 2" + System.lineSeparator());

            //전송 프로토콜 => xml, json => 객체
            bw.write("안녕 서버 1:안녕 서버 2" + System.lineSeparator());

            System.out.println("전송완료");

        } catch (IOException e) {
            System.out.println("[에러]"+e.getMessage());
        }finally {
            if(bw != null)try {bw.close();}catch(IOException e) {}

            if(socket != null)try {socket.close();}catch(IOException e) {}
            if(serverSocket != null)try {serverSocket.close();}catch(IOException e) {}
        }
    }

}