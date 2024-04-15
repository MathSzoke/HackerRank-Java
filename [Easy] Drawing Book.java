import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result
{

    /*
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */

    /*
        Parameters:
            n = o número de páginas do livro
            p = o número da página para onde virar

        Returns:
            O número mínimo de páginas para virar
    */
    public static int pageCount(int n, int p)
    {
        // Calcula o número de páginas a serem viradas a partir da frente do livro até a página 'p'.
        int fromFront = p / 2;
        // Calcula o número de páginas a serem viradas a partir de trás do livro até a página 'p'.
        // Subtrai o número total de páginas 'n' pela metade do número da página 'p'.
        int fromBack = n / 2 - p / 2;
        // Retorna o menor valor entre 'fromFront' e 'fromBack', representando a menor quantidade de páginas a serem viradas.
        return Math.min(fromFront, fromBack);
    }

}

class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
