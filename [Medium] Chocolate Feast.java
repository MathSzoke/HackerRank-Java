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

class Result {

    /*
     * Complete the 'chocolateFeast' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c
     *  3. INTEGER m
     */

    public static int chocolateFeast(int n, int c, int m) {
        int chocolates = n / c;
        int wrappers = chocolates;
        while (wrappers >= m) {
            int additionalChocolates = wrappers / m;
            chocolates += additionalChocolates;
            wrappers = wrappers % m + additionalChocolates;
        }
        return chocolates;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(Result.chocolateFeast(10, 2, 5)); // expected: 6

        System.out.println(Result.chocolateFeast(12, 4, 4)); // expected: 3

        System.out.println(Result.chocolateFeast(6, 2, 2)); // expected: 5

        System.out.println(Result.chocolateFeast(34587, 86, 33334)); // expected: 2
    }
}
