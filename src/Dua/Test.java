package Dua;

import java.util.concurrent.Semaphore;

public class
Test {
    public static void main(String[] args) {
        int giagiao = 5;
        Semaphore[] semaphore = new Semaphore[giagiao];
        for(int i = 0; i < giagiao;i++){
            semaphore[i] = new Semaphore(1);
        }
        Main[] main = new Main[giagiao];
        for(int i = 0; i < giagiao;i++){
            main[i] = new Main(i, semaphore[i], semaphore[(i + 1) % giagiao]);
            main[i].start();
        }
    }
}
