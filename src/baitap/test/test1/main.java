package baitap.test.test1;

public class main {
    public static void main(String[] args) {
        Thread t1 = new ino(1, 10, 1);
        Thread t2 = new ino(2, 20, 2);
        Thread t3 = new ino(1, 19, 2);
        t1.start();
        t2.start();
        t3.start();
    }
}
