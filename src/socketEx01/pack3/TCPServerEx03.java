package socketEx01.pack3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPServerEx03 {

    public static void main(String[] args) {

        Socket socket = null;

        BufferedReader br = null;

        try {
            System.out.println("클라이언트와 연결 합니다.");

            socket = new Socket("localhost",7777);
            System.out.println("클라이언트와 연결 되었습니다.");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));

            System.out.println("클라이언트에서 보낸 메시지 : " + br.readLine());

        } catch (UnknownHostException e) {
            System.out.println("[에러]"+e.getMessage());
        } catch (IOException e) {
            System.out.println("[에러]"+e.getMessage());
        }finally {
            if(br != null)try {br.close();}catch(IOException e) {}

            if(socket != null)try {socket.close();}catch(IOException e) {}
        }

    }

}