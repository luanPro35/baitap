package baitap.bai1.bai2;

public class Task2 implements Runnable {
    private Object one;
    private Object two;

    public Task2(Object one, Object two) {
        this.one = one;
        this.two = two;
    }

    public void run() {
        synchronized (one) {
            System.out.println(Thread.currentThread().getName() + " đã khóa one");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (two) {
                System.out.println(Thread.currentThread().getName() + " đã khóa two");
            }
        }
    }
}
