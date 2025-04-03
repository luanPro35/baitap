package Learn.b1;

public class RunEven implements Runnable {
    private Easy easy;
    private int max;
    public RunEven(Easy easy, int max) {
        this.easy = easy;
        this.max = max;
    }
    public void run() {
        for (int i = 2; i <= max; i+= 2) {
            easy.even(i);
        }
    }
}
