package pack7;

public class MainEx {
    public static void main(String[] args) {
        Account account = new Account();

        Client client1 = new Client(account);
        Client client2 = new Client(account);

        Thread t1 = new Thread(client1);
        Thread t2 = new Thread(client2);

        System.out.println("시작");

        t1.start();
        t2.start();

        System.out.println("종료");



    }
}
