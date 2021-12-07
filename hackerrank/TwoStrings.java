package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class TwoStrings {
    static String twoStrings(String s1, String s2) {
        int i;
        Map<Character, Integer> alphabet = new HashMap<>();
        for (i = 97; i < 123; i++) {
            alphabet.put((char)i, 0);
        }
        for (i = 0; i < s1.length(); i++) {
            alphabet.put(s1.charAt(i), 1);
        }
        for (i = 0; i < s2.length(); i++) {
            if (alphabet.get(s2.charAt(i)) == 1) {
                return "YES";
            }
        }
        return "NO";
    }
    public static void main(String[] args) {
        System.out.println(twoStrings("a", "art"));
        System.out.println(twoStrings("hi", "world"));
    }
}
