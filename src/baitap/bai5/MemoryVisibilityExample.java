package baitap.bai5;
public class MemoryVisibilityExample {
    private static boolean flag = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (!flag) {
            }
            System.out.println("Luồng 1 phát hiện flag thay đổi!");
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("Luồng 2 thay đổi giá trị flag.");
        });

        t1.start();
        t2.start();
    }
}

