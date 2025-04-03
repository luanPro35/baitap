package baitap.bai3;

public class NhiemVuUuTienCao implements Runnable{
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " đang chạy...");
        }
    }
}
