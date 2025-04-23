package Quanliungdung;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderDAO {
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrdersByCustomerId(int customerId) {
        List<Order> result = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCustomer().getId() == customerId) {
                result.add(order);
            }
        }
        return result;
    }

    public Order getOrder(int orderId) {
        for (Order order : orders) {
            if (order.getId() == orderId) {
                return order;
            }
        }
        return null;
    }

    public boolean removeOrder(int orderId) {
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (order.getId() == orderId) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
