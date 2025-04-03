package Learn.b1;

public class RunOdd implements Runnable {
    private Easy easy;
    private int max;
    public RunOdd(Easy easy, int max) {
        this.easy = easy;
        this.max = max;
    }
    public void run() {
        for(int i = 1; i <= max; i+= 2) {
            easy.odd(i);
        }
    }
}
