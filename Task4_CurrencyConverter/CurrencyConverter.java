import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {

    // Helper to get currency symbols for pretty printing
    private static String getCurrencySymbol(String currencyCode) {
        switch (currencyCode.toUpperCase()) {
            case "USD": return "$";
            case "EUR": return "€";
            case "INR": return "₹";
            case "GBP": return "£";
            case "JPY": return "¥";
            case "AUD": return "A$";
            case "CAD": return "C$";
            default: return currencyCode + " ";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("💱 Welcome to the CURRENCY CONVERTER 💱");

        try {
            // 1. Currency Selection: Choose base currency
            System.out.println("\n(Common codes: USD, EUR, INR, GBP, JPY, AUD, CAD)");
            System.out.print("Enter the BASE currency code (e.g., USD): ");
            String baseCurrency = scanner.next().toUpperCase();

            // 1. Currency Selection: Choose target currency
            System.out.print("Enter the TARGET currency code (e.g., INR): ");
            String targetCurrency = scanner.next().toUpperCase();

            // 3. Amount Input: Take amount to convert
            System.out.print("Enter the amount you want to convert: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("❌ Invalid amount. Exiting.");
                return;
            }
            double amount = scanner.nextDouble();

            System.out.println("\n🔄 Fetching real-time exchange rates...");

            // 2. Currency Rates: Fetch from a reliable free API
            // URL format provided by ExchangeRate-API (No API Key Required for basic public tier)
            String urlString = "https://api.exchangerate-api.com/v4/latest/" + baseCurrency;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                String jsonResponse = response.toString();

                // Simple JSON Parsing logic without external libraries (like Gson) to keep it simple
                // We search for "TARGET_CURRENCY_CODE": and extract the number that follows
                String searchStr = "\"" + targetCurrency + "\":";
                int targetIndex = jsonResponse.indexOf(searchStr);

                if (targetIndex != -1) {
                    int startIndex = targetIndex + searchStr.length();
                    // The value ends with a comma, or a closing brace if it's the last item
                    int endIndex = jsonResponse.indexOf(",", startIndex);
                    if (endIndex == -1) {
                        endIndex = jsonResponse.indexOf("}", startIndex);
                    }

                    String rateString = jsonResponse.substring(startIndex, endIndex).trim();
                    double exchangeRate = Double.parseDouble(rateString);

                    // 4. Currency Conversion
                    double convertedAmount = amount * exchangeRate;

                    // 5. Display Result
                    String baseSymbol = getCurrencySymbol(baseCurrency);
                    String targetSymbol = getCurrencySymbol(targetCurrency);

                    System.out.println("==========================================");
                    System.out.println("✅ Conversion Successful!");
                    System.out.printf("Current Exchange Rate: 1 %s = %.4f %s\n", baseCurrency, exchangeRate, targetCurrency);
                    System.out.printf("Converted Amount: %s%.2f\n", targetSymbol, convertedAmount);
                    System.out.println("==========================================");

                } else {
                    System.out.println("❌ Error: Target currency '" + targetCurrency + "' not found or is invalid.");
                }

            } else {
                System.out.println("❌ Failed to fetch exchange rates. HTTP Error Code: " + responseCode);
                System.out.println("Make sure your base currency '" + baseCurrency + "' is a valid standard currency code.");
            }

        } catch (Exception e) {
            System.out.println("❌ An error occurred while running the converter: " + e.getMessage());
            System.out.println("Please check your internet connection and try again.");
        } finally {
            scanner.close();
        }
    }
}
