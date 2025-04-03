package baitap.bai1.bai2;

public class TestMain {
    public static void main(String[] args) {
        Object one = new Object();
        Object two = new Object();
        Thread t1 = new Thread(new Task1(one, two));
        Thread t2 = new Thread(new Task2(one, two));
        t1.start();
        t2.start();
    }
}
