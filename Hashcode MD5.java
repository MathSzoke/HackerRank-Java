import java.util.*;
import java.security.MessageDigest;

public class Solution
{
    public static void main(String[] args)
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
                
        String a = sc.next();
        
        sc.close();
        
        try 
        {
            System.out.println(MD5(a));
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
    
    public static String MD5(String md5) {
        try 
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i)
            {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        }
        catch (java.security.NoSuchAlgorithmException e)
        {
            
        }
        return null;
    }
}
