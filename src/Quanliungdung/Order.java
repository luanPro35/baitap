package Quanliungdung;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private Customer customer;
    private List<OrderItem> items = new ArrayList<>();

    public Order(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public int getId() { return id; }
    public Customer getCustomer() { return customer; }
    public List<OrderItem> getItems() { return items; }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double getTotalAmount() {
        double sum = 0;
        for (OrderItem item : items) {
            sum += item.getTotalPrice();
        }
        return sum;
    }
}
