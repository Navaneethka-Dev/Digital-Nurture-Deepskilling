import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Forecasting {
    
    private static final Map<Integer, Double> forecastCache = new ConcurrentHashMap<>();
    
    public static double predictFutureValue(double principalAmount, double growthRate, int periods) {
        if (periods < 0) {
            throw new IllegalArgumentException("Periods cannot be negative.");
        }
        
        if (periods == 0) {
            return principalAmount;
        }
        
        if (forecastCache.containsKey(periods)) {
            return forecastCache.get(periods);
        }
        
        double nextPeriodValue = (1 + growthRate) * predictFutureValue(principalAmount, growthRate, periods - 1);
        
        forecastCache.put(periods, nextPeriodValue);
        
        return nextPeriodValue;
    }
    
    public static void resetCache() {
        forecastCache.clear();
    }
}
