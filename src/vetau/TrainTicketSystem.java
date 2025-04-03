package vetau;

public class TrainTicketSystem {
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter();

        Thread supplier = new Thread(new TicketSupplier(counter));
        Thread booth1 = new Thread(new TicketBooth(counter, "A"));
        Thread booth2 = new Thread(new TicketBooth(counter, "B"));
        Thread booth3 = new Thread(new TicketBooth(counter, "C"));

        supplier.start();
        booth1.start();
        booth2.start();
        booth3.start();
    }
}

