import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'surfaceArea' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY A as parameter.
     */
    
    public static int surfaceArea(List<List<Integer>> A) {
        int H = A.size();
        int W = A.get(0).size();
        int totalArea = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                int height = A.get(i).get(j);

                // Área do topo e da base
                totalArea += 2;

                // Área da frente
                if (i == 0) {
                    totalArea += height;
                } else {
                    totalArea += Math.max(0, height - A.get(i - 1).get(j));
                }

                // Área de trás
                if (i == H - 1) {
                    totalArea += height;
                } else {
                    totalArea += Math.max(0, height - A.get(i + 1).get(j));
                }

                // Área da esquerda
                if (j == 0) {
                    totalArea += height;
                } else {
                    totalArea += Math.max(0, height - A.get(i).get(j - 1));
                }

                // Área da direita
                if (j == W - 1) {
                    totalArea += height;
                } else {
                    totalArea += Math.max(0, height - A.get(i).get(j + 1));
                }
            }
        }
        return totalArea;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int H = Integer.parseInt(firstMultipleInput[0]);
        int W = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> A = new ArrayList<>();

        IntStream.range(0, H).forEach(i -> {
            try {
                A.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
