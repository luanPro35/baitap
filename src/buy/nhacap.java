package buy;

public class nhacap implements Runnable {
    private final Store store;
    public nhacap(Store store) {
        this.store = store;
    }
    public void run() {
        while (true) {
            store.nhacap();
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
