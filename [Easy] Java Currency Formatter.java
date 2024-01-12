import java.util.*;
import java.text.*;

public class Solution
{
    static String printCurrency(Locale locale, double payment)
    {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);  
        String currency = formatter.format(payment);  
        return currency;  
    }  
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        Locale INDIA = new Locale("en", "in");  
        
        System.out.println("US: " + printCurrency(Locale.US, payment));
        System.out.println("India: " + printCurrency(INDIA, payment));
        System.out.println("China: " + printCurrency(Locale.CHINA, payment));
        System.out.println("France: " + printCurrency(Locale.FRANCE, payment));
    }
}