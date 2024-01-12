This Java 8 challenge tests your knowledge of Lambda expressions!

Write the following methods that return a lambda expression performing a specified action:

1. PerformOperation isOdd(): The lambda expression must return true if a number is odd or false if it is even.
2. PerformOperation isPrime(): The lambda expression must return true if a number is prime or false if it is composite.
3. PerformOperation isPalindrome(): The lambda expression must return true if a number is a palindrome or false if it is not.

Input Format

Input is handled for you by the locked stub code in your editor.

Output Format

The locked stub code in your editor will print T lines of output.

Sample Input

The first line contains an integer, T (the number of test cases).

The T subsequent lines each describe a test case in the form of 2 space-separated integers:
The first integer specifies the condition to check for (1 for Odd/Even, 2 for Prime, or 3 for Palindrome). The second integer denotes the number to be checked.

5
1 4
2 5
3 898
1 3
2 12
Sample Output

EVEN
PRIME
PALINDROME
ODD
COMPOSITE

======================================================================================================================
======================================================================================================================
======================================================================================================================

import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++)
        {
            int operation = sc.nextInt();

            if (operation == 1)
            {
                int num = sc.nextInt();
                if (isOdd(num))
                    System.out.println("ODD");
                else
                    System.out.println("EVEN");
            }
            else if (operation == 2)            
            {
                int num = sc.nextInt();
                if (isPrime(num))
                    System.out.println("PRIME");
                else
                    System.out.println("COMPOSITE");
            }
            else if (operation == 3)
            {
                int num = sc.nextInt();
                if (isPalindrome(num))
                    System.out.println("PALINDROME");
                else
                    System.out.println("NOT PALINDROME");
            }
        }

        
        sc.close();
    }
    
    public static boolean isOdd(int number)
    {
        return number % 2 != 0;
    }

    public static boolean isPrime(int number)
    {
        if (number < 2)        
        {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++)
        {
            if (number % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int number)
    {
        String original = String.valueOf(number);
        String reverse = new StringBuilder(original).reverse().toString();
        return original.equals(reverse);
    }
}