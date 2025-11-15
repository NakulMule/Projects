import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {


    private static final Map<String, Double> rates = new HashMap<>();

    static {
        rates.put("EUR", 0.85);
        rates.put("GBP", 0.75);
        rates.put("INR", 74.0);
        rates.put("JPY", 109.6);
        rates.put("CAD", 1.25);
        rates.put("USD", 1.0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Quick Currency Converter!");


        System.out.println("Supported currencies: " + rates.keySet());
        System.out.println("Enter the currency you have:");


        String fromCurrency = scanner.next().toUpperCase();
        if (!rates.containsKey(fromCurrency)) {
            System.out.println("Sorry, we don't support that currency.");
            return;
        }

        System.out.println("Enter the currency you want to convert to:");
        String toCurrency = scanner.next().toUpperCase();
        if (!rates.containsKey(toCurrency)) {
            System.out.println("Sorry, we don't support that currency.");
            return;
        }

        System.out.println("Enter the amount you want to convert:");
        double amount;
        try {
            amount = Double.parseDouble(scanner.next());
            if (amount <= 0) {
                System.out.println("Please enter a positive amount.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount entered.");
            return;
        }


        double convertedAmount = convertCurrency(fromCurrency, toCurrency, amount);


        System.out.printf("%.2f %s is approximately %.2f %s.%n", amount, fromCurrency, convertedAmount, toCurrency);
        System.out.println("Thank you for using the Quick Currency Converter!");

        scanner.close();
    }


    private static double convertCurrency(String fromCurrency, String toCurrency, double amount) {
        double fromRate = rates.get(fromCurrency);
        double toRate = rates.get(toCurrency);
        return (amount / fromRate) * toRate;
    }
}
