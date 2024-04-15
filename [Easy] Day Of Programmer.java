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
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */
    
    // Método para calcular a data do Dia do Programador com base no ano fornecido
    public static String dayOfProgrammer(int year)
    {
        // Inicializa uma string para armazenar a data calculada
        String date = "";

        // Verifica se o ano é 1918, que foi o ano de transição entre os calendários Julian e Gregoriano na Rússia
        if (year == 1918)
        {
            // Para o ano de transição, a data do Dia do Programador é 26 de setembro
            date = "26.09.1918";
        }
        // Verifica se o ano é antes de 1918 e é um ano bissexto no calendário Julian, ou se é depois de 1918 e é um ano bissexto no calendário Gregoriano
        else if ((year < 1918 && year % 4 == 0) ||
                (year > 1918 && ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)))) {
            // Para anos bissextos, a data do Dia do Programador é 12 de setembro
            date = "12.09." + year;
        }
        // Se o ano não for um ano bissexto ou o ano de transição, a data do Dia do Programador é 13 de setembro
        else
        {
            date = "13.09." + year;
        }

        // Retorna a data do Dia do Programador no formato dd.mm.aaaa
        return date;
    }
}

class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
