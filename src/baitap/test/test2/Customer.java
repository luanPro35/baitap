package baitap.test.test2;

public class Customer extends Thread {
    private BankAccount account;
    private int amount;
    private String name;

    public Customer(BankAccount account, int amount, String name) {
        this.account = account;
        this.amount = amount;
        this.name = name;
    }

    public void run() {
        account.withdraw(amount, name);
    }
}
