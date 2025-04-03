package baitap.test.test2;

public class main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread t1 = new Customer(account, 700, "Khach 1");
        Thread t2 = new Customer(account, 500, "Khach 2");
        Thread t3 = new Customer(account, 700, "Khach 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
