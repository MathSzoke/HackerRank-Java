/*
* Basicamente, o principal objetivo deste desafio é:
*
* A cada 2 caracteres do input w do método biggerIsGreater, verificar qual caracter é maior na ordem alfabética
* Caso o caracter 1 na posição 1 for menor que o caracter 2 da posição 2,
* troca a posição entre esses caracteres para o caracter maior ficar na frente.
*
* Exemplo:
*
* ab
*
* b está na frente do A na ordem alfabética, portanto, troca a posição:
*
* ba
*
* outro exemplo:
*
* dkhc
*
* resultando em:
*
* hcdk
*
* A mudança do "hc" para frente ocorre porque o algoritmo sempre busca o menor caractere à direita do caractere escolhido para troca,
* garantindo que a nova string seja a menor possível.
* */

import java.io.*;
import java.math.*;
import java.text.*;
import java.security.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String biggerIsGreater(String w) {
        char[] chars = w.toCharArray();
        int i = chars.length - 2;

        // Encontrar o índice do primeiro caractere que é menor que o próximo caractere
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }

        // Se nenhum caractere atender à condição acima, a string não tem próxima permutação
        if (i < 0) {
            return "no answer";
        }

        // Encontrar o menor caractere à direita de chars[i] que é maior que chars[i]
        int j = chars.length - 1;
        while (chars[j] <= chars[i]) {
            j--;
        }

        // Trocar os caracteres em chars[i] e chars[j]
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;

        // Ordenar a parte da string à direita de chars[i] em ordem crescente
        reverse(chars, i + 1, chars.length - 1);

        return new String(chars);
    }

    public static void reverse(char[] chars, int start, int end)
    {
        while (start < end)
        {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result.biggerIsGreater(w);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
