package buy;

public class Store {
    private int count = 0;
    private final int MAX_BREAD = 5;
    public synchronized void nhacap() {
        while (count >= MAX_BREAD) {
            try{
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        System.out.println("Nha cung da cung cap 1 o. So banh mi hien co: " + count);
        notify();
    }

    public synchronized void khach() {
        while(count == 0){
            try{
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println("Khach hang da mua 1 o. So banh mi hien co: " + count);
        notify();
    }
}
