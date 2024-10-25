import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import src.MonthReturns;

public class Main {

    public static void main(String[] args) throws IOException {

        // Date variables
        Locale.setDefault(Locale.US);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmtMonth = DateTimeFormatter.ofPattern("MM/yyyy");

        // URL variables
        String urlString = "https://ujay.eastus.cloudapp.azure.com/rentabilidades.txt";
        URL url;
        BufferedReader content;

        // Data variables
        HashMap<String, MonthReturns> months = new HashMap<>();
        
        // Create URL object and throw exception if invalid URL
        try {
            url = new URI(urlString).toURL();
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }

        // Read URL content and create respective objects
        try {
            content = new BufferedReader(new InputStreamReader(url.openStream()));
            String str;
            while ((str = content.readLine()) != null) {

                if (str.contains("Data")) {
                    // cabeçalho
                }
                else {
                    // Parsing informations
                    LocalDate date = LocalDate.parse(str.split(";")[0],fmt);
                    String formattedDate = date.format(fmtMonth);
                    Double value = Double.valueOf(str.split(";")[1]);

                    MonthReturns month;

                    try {
                        // Get month-returns object if exists
                        month = months.get(formattedDate);
                        month.setReturn(value);

                    } catch (Exception e) {
                        // Create month-returns object if not existing
                        month = new MonthReturns(formattedDate);
                        month.setReturn(value);
                        months.put(formattedDate, month);

                    }
                    // Both statements add the month-returns object inside HashMap months
                    months.put(formattedDate, month);
                }
            }
        } catch (IOException e) {
            throw new IOException();
        }
        content.close();

        // Calculate Monthly Return by sum of returns
        // New HashMap for results only
        HashMap<String, Double> results = new HashMap<>();
        for (String monthString : months.keySet()) {
            results.put(monthString, months.get(monthString).calculateMonthReturn());
        }

        // Filter HashMap by List sort in descending order
        List<Map.Entry<String, Double>> list = new ArrayList<>(results.entrySet());
        list.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Print informations in order
        for ( Map.Entry<String, Double> month : list) {
            System.out.println(month.getKey() + ":" + month.getValue());
        }
        

    }

}
