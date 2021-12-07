package codesignal;

import java.util.Arrays;
import java.util.Comparator;

public class longestWord {
    public static void main(String[] args) {
        System.out.println(longestWord("Ready, steady, go!"));
    }

    static String longestWord(String text) {
        StringBuilder sb = new StringBuilder();
        for (char character: text.toCharArray()) {
            if (Character.isAlphabetic(character)) {
                sb.append(character);
            }
            else {
                sb.append(' ');
            }
        }

        return Arrays
            .stream(sb.toString()
                .trim()
                .replaceAll(" +", " ")
                .split(" ")
            )
            .max(Comparator.comparing(String::length))
            .get();
    }
}
