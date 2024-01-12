import java.util.*;
import java.security.*;

public class Solution
{
    public static void main(String[] args)
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        
        String a = sc.next();
        
        System.out.println(SHA256(a));
    }
    
    public static String SHA256(String sha)
    {
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] array = md.digest(sha.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : array)
            {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } 
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}