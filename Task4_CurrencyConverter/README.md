# 💱 Currency Converter - Project Explanation

This Java console application implements the **Currency Converter** internship task. It satisfies all 5 required steps provided in your task instructions.

## 🚀 How to Run the Converter
1. Open your terminal or command prompt in the project folder: 
   ```bash
   cd "C:\Users\Basudev\Desktop\CodeWithTaslim\CODSOFT\Task4_CurrencyConverter"
   ```
2. Compile the code:
   ```bash
   javac CurrencyConverter.java
   ```
3. Run the compiled application:
   ```bash
   java CurrencyConverter
   ```

---

## ✅ Task Requirements Implemented

1. **Currency Selection**:
   - The user is first prompted to manually input strings for their Base Currency code (e.g., `USD`) and their Target Currency code (e.g., `INR`). 

2. **Currency Rates**:
   - Fetches **real-time** exchange rates from a completely free, highly reliable public json API without requiring any authentication keys (`https://api.exchangerate-api.com/v4/latest/{BASE}`).
   - The networking is handled securely inside an `HttpURLConnection` block mapping over HTTP GET requests.

3. **Amount Input**:
   - An interactive console prompt queries the user for a double value of exactly how much money they want converted. E.g., `100.50`. Asserts `.hasNextDouble()` validation checks to assure no crashing if a user inputs alphabetical characters natively.

4. **Currency Conversion**:
   - The returned JSON from the API is parsed (manually to avoid requiring extensive libraries inside single-file homework submissions), pulling out the specific `exchange rate` double for the target parameter successfully.
   - It performs the mathematical conversion equation strictly: `convertedAmount = amount * exchangeRate`.

5. **Display Result**:
   - The `.printf()` UI handles formatting decimals directly to 2 points of precision and maps the correct specific world currency symbols (e.g., automatically replacing `EUR` to `€` during print layout).
   - Successfully shows exactly what the target currency result calculates out to!
