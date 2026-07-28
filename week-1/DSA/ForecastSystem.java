import java.util.*;

public class ForecastSystem {

    // For predicting future value by running  year-by-year recursively
    static double calculateFutureValue(double currentVal, double rate, int years) {
        // Base Case
        if (years == 0) {
            return currentVal;
        }

        // Recursive Case
        double nextYearValue = currentVal * (1 + rate);
        return calculateFutureValue(nextYearValue, rate, years - 1);
    }

    public static void main(String[] args) {
        System.out.println("--- Financial Forecasting Tool Live ---");

        double startingPrincipal = 1000.0; // Initial amount 
        double annualGrowthRate = 0.05;    // Constant 5% growth rate
        int forecastingPeriod = 5;         // Predicting next 5 years

       
        double projectedValue = calculateFutureValue(startingPrincipal, annualGrowthRate, forecastingPeriod);

        System.out.println("\n--- Forecast Summary ---");
        System.out.println("Initial Investment: $" + startingPrincipal);
        System.out.println("Growth Rate: " + (annualGrowthRate * 100) + "% annually");
        System.out.println("Predicted Value after " + forecastingPeriod + " years: $" + String.format("%.2f", projectedValue));
    }
}