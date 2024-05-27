package pack2;

public class Go extends Thread{

    public void run(){

        // 스레드가 처리 해야 할 작업 기술
        for(int i =1; i<=10; i++){
            System.out.println("Go : " + i);
        }
    }
}
