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
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player)
    {
        // Lista para armazenar o ranking dos jogadores
        List<Integer> result = new ArrayList<>();

        // Remove duplicatas da lista de pontuações classificadas e armazena em uma nova lista
        List<Integer> distinct = ranked.stream().distinct().collect(Collectors.toList());
        // Inicializa o índice j como o índice da última pontuação classificada
        int j = distinct.size() - 1;
        // Itera sobre as pontuações dos jogadores
        for (int i : player)
        {
            // Enquanto houver pontuações classificadas e a pontuação do jogador for maior ou igual à pontuação classificada
            while (j >= 0)
            {
                if (i >= distinct.get(j)) // Se a pontuação do jogador for maior ou igual à pontuação classificada atual, diminui j
                {
                    j--;
                }
                else // Se a pontuação do jogador for menor que a pontuação classificada, adiciona o ranking à lista e sai do loop
                {
                    result.add(j + 2);
                    break;
                }
            }

            if (j < 0) // Se todas as pontuações classificadas forem menores que a pontuação do jogador, o jogador está em primeiro lugar
            {
                result.add(1);
            }
        }

        // Retorna a lista com o ranking dos jogadores
        return result;
    }
}

class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
