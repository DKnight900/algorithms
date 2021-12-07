package codesignal;

import java.util.HashMap;
import java.util.Map;

public class IsBeautifulString {
    public static void main(String[] args) {
        System.out.println(isBeautifulString("bbbaacdafe"));
        System.out.println(isBeautifulString("bbc"));
    }
    static boolean isBeautifulString(String inputString) {
        Map<Character, Integer> alphabet = new HashMap<>();
        for (int i = 97; i < 123; i++) {
            alphabet.put((char)i, 0);
        }
        for (Character character: inputString.toCharArray()) {
            alphabet.computeIfPresent(character, (key, value) -> ++value);
        }
        for (int i = 98; i < 123; i++) {
            if (alphabet.get((char)i) > alphabet.get((char)(i - 1))) {
                return false;
            }
        }
        return true;
    }
}
