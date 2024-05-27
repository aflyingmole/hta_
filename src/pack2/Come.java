package pack2;

public class Come extends Thread{

    public void run(){

        for(int i =1; i<=10; i++){
            System.out.println("Come : " + i);
        }
    }
}
