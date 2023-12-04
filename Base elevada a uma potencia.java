import java.util.*;

class Solution 
{
    public static void main(String[] args) 
    
    {
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt(); // numero de vezes a ser realizado a quantidade de equação passada por esta variavel.
        
        for (int i = 0; i < t; i++) 
        {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            
            printSeries(a, b, n);
        }

        in.close();
    }

    private static void printSeries(int a, int b, int n) 
    {
        int currentValue = a;

        for (int j = 0; j < n; j++)
        {
            currentValue = currentValue + ((int) Math.pow(2, j) * b);
            // A função Math.pow em Java é usada para calcular uma base elevada a uma potência. Math.pow(base, exponente);
            // Ela aceita dois parâmetros: a base e a potência, e retorna o resultado da operação. A assinatura do método é a seguinte:
	    // Math.pow(base, exponente);
 	    // base: O número que será elevado à potência. 
	    // exponente: A potência à qual a base será elevada.
            // Neste exemplo, Math.pow(2, 3) retorna 2 elevado à potência de 3, ou seja: "2 * 2 * 2": (2 * 2 = 4 * 2 = 8).

            System.out.print(currentValue + " ");
        }
        System.out.println(); // Pula para a próxima linha após imprimir a série.
    }
}