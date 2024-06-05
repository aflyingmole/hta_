package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class ChatServer {
    private HashMap<String, OutputStream> clients;

    public static void main(String args[]) {
        // TODO Auto-generated method stub
        new ChatServer().start();
    }

    public ChatServer() {
        clients = new HashMap<String, OutputStream>();
        // Collections.synchronizedMap(clients)
    }

    public void start() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(2400);
            System.out.println("서버가 시작되었습니다.");
            while (true) {
                socket = serverSocket.accept();
                System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "]" + "에서접속하였습니다.");
                ServerReceiver thread = new ServerReceiver(socket);
                thread.start();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void sendToAll(String msg) {
        Iterator<String> it = clients.keySet().iterator();

        while (it.hasNext()) {
            try {
                DataOutputStream out = (DataOutputStream) clients.get(it.next());
                out.writeUTF(msg);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    class ServerReceiver extends Thread {
        private Socket socket;
        private DataInputStream in;
        private DataOutputStream out;

        public ServerReceiver(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public void run() {
            String name = "";
            try {
                name = in.readUTF();
                sendToAll("#" + name + "님이 들어오셨습니다.");
                clients.put(name, out);

                System.out.println("현재 서버접속자 수는 " + clients.size() + "입니다c.");

                while (in != null) {
                    sendToAll(in.readUTF());
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                sendToAll("#" + name + "님이 나가셨습니다.");
                clients.remove(name);
                System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "]" + " 에서접속을 종료하였습니다.");
                System.out.println("현재 서버접속자 수는 " + clients.size() + " 입니다.");
            }
        }
    }
}
