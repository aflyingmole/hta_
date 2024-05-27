package pack7;

public class Account {
    // 통장 잔고
    private int balance = 1000;

    public int getBalance() {
        return balance;
    }
    
    // 인출 메서드
    public synchronized void withdraw(int money){
        if(balance >= money){
            try {
                Thread.sleep(1000);
                // 통장에서 인출
                balance -= money;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("잔고가 없습니다");
        }
    }
}
