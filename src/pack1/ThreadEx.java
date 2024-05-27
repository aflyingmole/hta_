package pack1;

public class ThreadEx {
    public static void main(String[] args) {
        Go go = new Go();
        Come come = new Come();

        System.out.println("시작");

        // 순차처리 - 실행순서가 있음
        go.run();
        come.run();

        System.out.println("끝");
    }
}
