package buy;

public class TestMain {
    public static void main(String[] args) {
        Store store = new Store(); // Cửa hàng

        Thread quancap = new Thread(new nhacap(store));
        Thread khachan = new Thread(new khach(store));

        quancap.start();
        khachan.start();
    }
}
