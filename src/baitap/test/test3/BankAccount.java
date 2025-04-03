package baitap.test.test3;

public class BankAccount {
    private int balance = 1000;
    public synchronized void deposit(int amount, String name) {
        balance += amount;
        System.out.println(name + " deposited " + amount + " to " + balance);
    }
    public synchronized void withdraw(int amount, String name) {
        if(balance >= amount) {
            System.out.println(name + " đang rút " + amount);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println(name + " đã rút " + amount + ", số tiền hiện tại " + balance);
        }
        else {
            System.out.println(name + " muốn rút " + amount + ", nhưng không đủ " + balance);
        }
    }
    public int getBalance() {
        return balance;
    }
}
