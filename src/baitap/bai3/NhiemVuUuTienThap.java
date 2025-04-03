package baitap.bai3;

public class NhiemVuUuTienThap implements Runnable {
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " đã được chạy!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
