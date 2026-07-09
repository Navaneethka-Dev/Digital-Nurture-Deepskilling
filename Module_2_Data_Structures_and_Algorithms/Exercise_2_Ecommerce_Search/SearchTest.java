import java.util.Arrays;

public class SearchTest {
    public static void main(String[] args) {
        System.out.println("--- Asymptotic Notation Analysis ---");
        System.out.println("Big O notation helps analyze worst-case time complexity of algorithms.");
        System.out.println("Linear Search: Best O(1), Average O(n), Worst O(n)");
        System.out.println("Binary Search: Best O(1), Average O(log n), Worst O(log n)");
        System.out.println("------------------------------------");
        
        Product[] products = {
            new Product(103, "Laptop", "Electronics"),
            new Product(101, "Smartphone", "Electronics"),
            new Product(105, "Desk Chair", "Furniture"),
            new Product(102, "Coffee Maker", "Appliances"),
            new Product(104, "Notebook", "Stationery")
        };
        
        System.out.println("Performing Linear Search for Product ID 105:");
        Product foundLinear = SearchAlgorithms.linearSearch(products, 105);
        System.out.println(foundLinear != null ? "Found: " + foundLinear : "Not Found");
        
        System.out.println("\nSorting array for Binary Search...");
        Arrays.sort(products);
        
        System.out.println("Performing Binary Search for Product ID 102:");
        Product foundBinary = SearchAlgorithms.binarySearch(products, 102);
        System.out.println(foundBinary != null ? "Found: " + foundBinary : "Not Found");
        
        System.out.println("\n--- Algorithm Suitability ---");
        System.out.println("Binary Search is more suitable for large E-commerce platforms because");
        System.out.println("its O(log n) time complexity is vastly faster for massive datasets,");
        System.out.println("assuming the data can be kept sorted.");
    }
}
