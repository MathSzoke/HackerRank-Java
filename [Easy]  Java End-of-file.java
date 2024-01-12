import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution
{

    public static void main(String[] args)
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */        
        
        // Sample Input

        // Hello world
        // I am a file
        // Read me until end-of-file.
        
        Scanner sc = new Scanner(System.in);

        int i = 1;

        while (sc.hasNextLine())
        {
            String line = sc.nextLine();
            System.out.println(i + " " + line);
            i++;
        }
        // Sample Output

        // 1 Hello world
        // 2 I am a file
        // 3 Read me until end-of-file.
    }
}