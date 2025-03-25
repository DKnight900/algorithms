package neetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EncodeDecodeStrings {
    public static void main(String[] args) {
        System.out.println(decode(encode(List.of("ave", "taza", "lapiz"))));
        System.out.println(decode(encode(List.of("2#", "3#", "oso"))));
        System.out.println(decode(encode(List.of("we","say",":","yes","!@#$%^&*()"))));

    }

    private static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        strs.forEach(str -> sb.append(str.length() + "#" + str)); // O(n)
        return sb.toString();
    }

    private static List<String> decode(String str) {
        int i = 0;
        List<String> strs = new ArrayList<>();
        while(i < str.length()) { // O(n)
            int currentLength = Integer.parseInt(str.substring(i)
                .chars()
                .mapToObj(c -> String.valueOf((char) c))
                .takeWhile(s -> s.charAt(0) != '#')
                .collect(Collectors.joining()));
            strs.add(str.substring(i + 1 + String.valueOf(currentLength).length(), i + currentLength + 1 + String.valueOf(currentLength).length()));
            i += currentLength + String.valueOf(currentLength).length() + 1;
        }
        return strs;
    }
}
