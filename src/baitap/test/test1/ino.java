package baitap.test.test1;

public class ino extends Thread {
    private int start, end, step;

    public ino(int start, int end, int step) {
        this.start = start;
        this.end = end;
        this.step = step;
    }

    public void run() {
        for (int i = start; i <= end; i += step) {
            System.out.println(i);
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
