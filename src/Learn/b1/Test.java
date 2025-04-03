package Learn.b1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Easy easy = new Easy();
        Thread t1 = new Thread(new RunOdd(easy, n));
        Thread t2 = new Thread(new RunEven(easy, n));
        t1.start();
        t2.start();
    }
}
