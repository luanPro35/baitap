package vetau;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class TicketCounter {
    private Queue<Integer> ticketQueue = new LinkedList<>();
    private Set<Integer> soldTickets = new HashSet<>();
    private final int MAX_TICKETS = 10;
    private boolean noMoreTickets = false;

    public synchronized int buyTicket(String buyerName) {
        while (ticketQueue.isEmpty() && !noMoreTickets) {
            try {
                System.out.println(buyerName + " đang chờ vé...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (ticketQueue.isEmpty()) {
            System.out.println(buyerName + " đến mua nhưng đã hết vé!");
            return -1;
        }

        int ticketNumber = ticketQueue.poll();
        soldTickets.add(ticketNumber);
        System.out.println(buyerName + " đã mua vé số: " + ticketNumber);
        notifyAll();
        return ticketNumber;
    }

    public synchronized void supplyTickets() {
        if (ticketQueue.size() >= 5) return;

        Random random = new Random();
        for (int i = ticketQueue.size(); i < 5; i++) {
            int ticketNumber;
            do {
                ticketNumber = random.nextInt(100) + 1;
            } while (soldTickets.contains(ticketNumber) || ticketQueue.contains(ticketNumber));

            ticketQueue.add(ticketNumber);
            System.out.println("Nhà cung cấp đã thêm vé số: " + ticketNumber);
        }

        if (soldTickets.size() >= MAX_TICKETS) {
            noMoreTickets = true;
            System.out.println("Nhà cung cấp: Đã hết vé!");
        }

        notifyAll();
    }
}

