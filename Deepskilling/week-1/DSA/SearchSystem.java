import java.util.*;

class Product {
    int productId;
    String productName;
    String category;

  
    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

   
    @Override
    public String toString() {
        return productName + " [" + category + " | Item ID: " + productId + "]";
    }
}

public class SearchSystem {

    // For looping line-by-line
    static Product linearSearch(Product[] list, int findId) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].productId == findId) {
                return list[i];
            }
        }
        return null;
    }

    //BS
    static Product binarySearch(Product[] sortedList, int findId) {
        int low = 0;
        int high = sortedList.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (sortedList[middle].productId == findId) {
                return sortedList[middle];
            }
            if (sortedList[middle].productId < findId) {
                low = middle + 1; // Throw away the smaller left half
            } else {
                high = middle - 1; // Throw away the larger right half
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("--- Catalog Search System Active ---");

      
        Product[] catalog = {
            new Product(201, "Wireless Mouse", "Gadgets"),
            new Product(204, "Running Shoes", "Apparel"),
            new Product(209, "Coffee Mug", "Kitchenware"),
            new Product(215, "Desk Lamp", "HomeDecor")
        };

        int lookForId = 209;

        System.out.println("\n--- Initializing Linear Method ---");
        Product itemFound1 = linearSearch(catalog, lookForId);
        System.out.println("Returned Entry -> " + (itemFound1 != null ? itemFound1 : "No Record"));

        System.out.println("\n--- Initializing Binary Method ---");
        Product itemFound2 = binarySearch(catalog, lookForId);
        System.out.println("Returned Entry -> " + (itemFound2 != null ? itemFound2 : "No Record"));
    }
}