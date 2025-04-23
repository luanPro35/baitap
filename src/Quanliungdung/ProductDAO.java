package Quanliungdung;

import java.util.HashMap;
import java.util.Map;

public class ProductDAO {
    private Map<Integer, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public Product getProductById(int id) {
        return products.get(id);
    }
}
