package Quanliungdung;

import java.util.HashMap;
import java.util.Map;

public class CustomerDAO {
    private Map<Integer, Customer> customers = new HashMap<>();

    public void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public Customer getCustomerById(int id) {
        return customers.get(id);
    }
}
