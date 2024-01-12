import java.util.*;

public class Solution
{
    public static void main(String[] args)
	{
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        
        /* Remover espaços extras antes e depois da string */
        s = s.trim();
        
        /* Substituir caracteres especiais por espaços */
        s = s.replaceAll("[^\\p{Alnum}]", " ");
        
        /* Dividir a string em palavras */
        String[] words = s.split("\\s+"); 

        System.out.println(s.length() == 0 ? 0 : words.length);
        if (words.length > 0 && !words[0].isEmpty())
        {
            for (String word : words)
            {
                System.out.println(word);
            }
        }
        
        scan.close();
    }
}

