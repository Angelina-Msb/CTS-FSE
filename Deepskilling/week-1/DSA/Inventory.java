import java.util.*;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    // Sets up our product data when creating a new item
    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // printing
    @Override
    public String toString() {
        return productName + " (Stock: " + quantity + " | Price: $" + price + ")";
    }
}

public class Inventory {
    // The main tracker
    static HashMap<Integer, Product> productMap = new HashMap<>();

    // For avoiding dubs n addd new product id its missing
    static void addProduct(Product p) {
        if (productMap.containsKey(p.productId)) {
            System.out.println("[ERROR] Entry skipped: ID " + p.productId + " already exists.");
        } else {
            productMap.put(p.productId, p);
            System.out.println("[SUCCESS] Stored: " + p.productName);
        }
    }

    // finding an existing product 
    static void updateProduct(int id, int qty, double price) {
        if (productMap.containsKey(id)) {
            Product p = productMap.get(id);
            p.quantity = qty;
            p.price = price;
            System.out.println("[UPDATE] Modified entry ID: " + id);
        } else {
            System.out.println("[ERROR] Abort: ID " + id + " not found.");
        }
    }

    // For completely removing a product
    static void deleteProduct(int id) {
        if (productMap.containsKey(id)) {
            productMap.remove(id);
            System.out.println("[DELETE] Purged entry ID: " + id);
        } else {
            System.out.println("[ERROR] Abort: ID " + id + " not found.");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Warehouse System Live ---");
        
        addProduct(new Product(101, "Laptop", 10, 50000));
        addProduct(new Product(102, "Phone", 20, 20000));

        System.out.println("\n--- Running Update Protocol ---");
        updateProduct(101, 15, 55000);

        System.out.println("\n--- Running Purge Protocol ---");
        deleteProduct(102);

        System.out.println("\n--- Current Storage Dump ---");
        System.out.println(productMap);
    }
}