package baitap.bai4;
public class ThreadInterruptionExample {
    public static void main(String[] args) {
        Thread luong = new Thread(new NhiemVuChayVoHan());
        luong.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        luong.interrupt();
    }
}

class NhiemVuChayVoHan implements Runnable {
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Luồng đang chạy...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Luồng bị ngắt!");
                break;
            }
        }
        System.out.println("Luồng đã kết thúc.");
    }
}

