package pack2;

public class ThreadEx {
    public static void main(String[] args) {

        Go go = new Go();
        Come come = new Come();

        System.out.println("시작");

        // 스레드 실행 방법 X
        //go.run();
        //come.run();

        // 스레드 실행 방법
        go.start();
        come.start();

        System.out.println("끝");
    }
}
