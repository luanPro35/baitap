package baitap.test.test3;

public class main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        Thread t1 = new Customer(account, "Khach 1");
        Thread t2 = new Customer(account, "Khach 2");
        Thread t3 = new Customer(account, "Khach 3");
        Thread t4 = new Customer(account, "Khach 4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
