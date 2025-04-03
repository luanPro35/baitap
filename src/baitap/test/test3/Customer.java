package baitap.test.test3;

import java.util.Random;

public class Customer extends Thread {
    private BankAccount account;
    private String name;
    private Random rand = new Random();
    public Customer(BankAccount account, String name) {
        this.account = account;
        this.name = name;
    }
    public void run() {
        for(int i = 0; i < 3; i++){
            int action = rand.nextInt(2);
            int amount = rand.nextInt(100);
            if(action == 0){
                account.withdraw(amount, name);
            }
            else{
                account.deposit(amount, name);
            }
            try {
                Thread.sleep(rand.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
