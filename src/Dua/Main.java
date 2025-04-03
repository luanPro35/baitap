package Dua;

import java.util.concurrent.Semaphore;

public class Main extends Thread {
    private final int id;
    private final Semaphore duatrai, duaphai;

    public Main(int id, Semaphore duatrai, Semaphore duaphai) {
        this.id = id;
        this.duatrai = duatrai;
        this.duaphai = duaphai;
    }

    private void cho() throws InterruptedException {
        System.out.println("Triết gia " + id + " đang chờ");
        Thread.sleep(1000);
    }

    private void eat() throws InterruptedException {
        System.out.println("Triết gia " + id + " đang ăn");
        Thread.sleep(1000);
    }

    @Override
    public void run() {
        try{
            while (true){
                cho();
                if(id % 2 == 0){
                    duatrai.acquire();
                    duaphai.acquire();
                }
                else{
                    duaphai.acquire();
                    duatrai.acquire();
                }
                eat();
                duatrai.release();
                duaphai.release();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
