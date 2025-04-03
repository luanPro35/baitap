package vetau;

public class TicketBooth implements Runnable {
    private TicketCounter counter;
    private String boothName;

    public TicketBooth(TicketCounter counter, String boothName) {
        this.counter = counter;
        this.boothName = boothName;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            String buyerName = "Khách " + i + " (Quầy " + boothName + ")";
            counter.buyTicket(buyerName);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

