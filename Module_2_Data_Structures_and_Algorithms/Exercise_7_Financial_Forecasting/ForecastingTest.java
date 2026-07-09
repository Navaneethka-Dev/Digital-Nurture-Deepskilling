public class ForecastingTest {
    public static void main(String[] args) {
        System.out.println("--- Understanding Recursive Algorithms ---");
        System.out.println("Recursion simplifies problems by breaking them down into smaller");
        System.out.println("sub-problems of the same type, until a base case is reached.");
        System.out.println("------------------------------------------");
        
        double initialValue = 1000.0;
        double growthRate = 0.05;
        int years = 10;
        
        System.out.println("Calculating future value for $" + initialValue + " over " + years + " years at 5%...");
        double futureValue = Forecasting.predictFutureValue(initialValue, growthRate, years);
        System.out.printf("Predicted Future Value: $%.2f%n", futureValue);
        
        System.out.println("\n--- Analysis & Optimization ---");
        System.out.println("Time Complexity: O(n) where n is the number of years.");
        System.out.println("To optimize and avoid excessive computation for overlapping");
        System.out.println("subproblems, we can use Memoization (caching results).");
    }
}
