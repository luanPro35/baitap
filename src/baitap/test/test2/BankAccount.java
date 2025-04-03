package baitap.test.test2;

public class BankAccount {
    private int balance = 1000;

    public synchronized void withdraw(int amount, String name) {
        if (balance >= amount) {
            System.out.println(name + " dang rut " + amount);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println(name + " da rut " + amount + ". So du hien tai: " + balance);
        } else {
            System.out.println(name + " muon rut " + amount + " nhung khong du tien!");
        }
    }
}
