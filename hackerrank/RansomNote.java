package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> wordsCount = new HashMap<>();
        Arrays.stream(note).forEach( word ->
            {
                wordsCount.computeIfPresent(word, (key, ocurrences) -> ++ocurrences);
                wordsCount.putIfAbsent(word, 1);
            }
        );

        Arrays.stream(magazine)
            .forEach(word -> wordsCount.computeIfPresent(word, (key, ocurrences) -> --ocurrences));
        String result = wordsCount.values().stream().allMatch(value -> value <= 0) ? "Yes" : "No";
        System.out.println(result);
    }

    public static void main(String[] args) {
        String[] magazine = {"two", "times", "three", "is", "not", "four"};
        String[] note = {"two", "times", "two", "is", "four"};
//        String[] magazine = {"give", "me", "one", "grand", "today", "night"};
//        String[] note = {"give", "one", "grand", "today"};
//        String[] magazine = {"apgo", "clm", "w", "lxkvg", "mwz", "elo", "bg", "elo", "lxkvg", "elo", "apgo", "apgo", "w", "elo", "bg"};
//        String[] note = {"elo", "lxkvg", "bg", "mwz", "clm", "w"};

        checkMagazine(magazine, note);

    }
}
