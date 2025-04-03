package buy;

public class khach implements Runnable {
    private final Store store;
    public khach(Store store) {
        this.store = store;
    }
    public void run(){
        while(true){
            store.khach();
            try {
                Thread.sleep(1500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
