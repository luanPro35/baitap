package vetau;

public class TicketSupplier implements Runnable {
    private TicketCounter counter;

    public TicketSupplier(TicketCounter counter) {
        this.counter = counter;
    }

    public void run() {
        while (true) {
            counter.supplyTickets();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

