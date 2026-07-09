import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Utility class for financial forecasting using dynamic programming.
 */
public class Forecasting {
    
    // Using ConcurrentHashMap for thread-safe memoization
    private static final Map<Integer, Double> forecastCache = new ConcurrentHashMap<>();
    
    /**
     * Predicts the future value of an investment over a number of periods.
     * Uses memoization to optimize repeated recursive calculations.
     * 
     * @param principalAmount the initial present value
     * @param growthRate      the fixed growth rate (e.g., 0.05 for 5%)
     * @param periods         number of periods to forecast
     * @return the predicted future value
     */
    public static double predictFutureValue(double principalAmount, double growthRate, int periods) {
        if (periods < 0) {
            throw new IllegalArgumentException("Periods cannot be negative.");
        }
        
        // Base Case
        if (periods == 0) {
            return principalAmount;
        }
        
        // Return cached result if available
        if (forecastCache.containsKey(periods)) {
            return forecastCache.get(periods);
        }
        
        // Recursive Calculation: FV = (1 + r) * Predict(FV, periods - 1)
        double nextPeriodValue = (1 + growthRate) * predictFutureValue(principalAmount, growthRate, periods - 1);
        
        // Cache the computed result
        forecastCache.put(periods, nextPeriodValue);
        
        return nextPeriodValue;
    }
    
    /**
     * Clears the forecasting cache. Useful when recalculating with different principal or rate.
     */
    public static void resetCache() {
        forecastCache.clear();
    }
}
