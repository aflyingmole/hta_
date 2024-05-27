package pack7;

import java.lang.ref.Cleaner;

public class Client implements Runnable {
    private Account account;

    public Client(Account account) {
        this.account = account;
    }


    @Override
    public void run() {
        while (account.getBalance() > 0) {
            // 100, 200, 300
            int money = (int) (Math.random() * 3 + 1) * 100;
            account.withdraw(money);

            System.out.println("통장 잔고 : " + account.getBalance());
        }
    }
}
