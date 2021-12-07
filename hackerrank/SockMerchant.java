package hackerrank;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SockMerchant {

    static int sockMerchant(int n, int[] ar) {
        int matchingPairs = 0;
        Map<Integer, Integer> colors = new HashMap<>();
        for (int i = 0; i < n; i++) {
            colors.computeIfPresent(ar[i], (k, v) -> v + 1);
            colors.putIfAbsent(ar[i], 1);
        }

        for (int value : colors.values()) {
            matchingPairs += value / 2;
        }
        return matchingPairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[] array = {10, 20, 20, 10, 10, 30, 50, 10, 20};

        System.out.println(sockMerchant(9, array));
    }
}
                             
