import java.util.HashMap;
import java.util.Map;
public class Forecasting {
    private static Map<Integer, Double> memo = new HashMap<>();
    public static double predictFutureValue(double presentValue, double growthRate, int periods) {
        if (periods == 0) return presentValue;
        if (memo.containsKey(periods)) return memo.get(periods);
        double value = (1 + growthRate) * predictFutureValue(presentValue, growthRate, periods - 1);
        memo.put(periods, value);
        return value;
    }
}
