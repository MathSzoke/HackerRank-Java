import java.util.Scanner;
import java.util.regex.*;

public class Solution
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases > 0)
        {
			String pattern = in.nextLine();
          	
            t(pattern);
            
            testCases--;
		}
	}
    
    public static void t(String regex)
    {
        String isValid = "";
        try
        {
            Pattern.compile(regex);
            isValid = "Valid";
        }
        catch(PatternSyntaxException e)
        {
            isValid = "Invalid";
        }
        
        System.out.println(isValid);
    }
}