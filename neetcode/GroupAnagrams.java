package neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagramsNonOptimal(new String[]{"act","pots","tops","cat","stop","hat"}));
        System.out.println(groupAnagramsNonOptimal(new String[]{"cab","tin","pew","duh","may","ill","buy","bar","max","doc"}));
        System.out.println(groupAnagramsNonOptimal(new String[]{"x"}));
        System.out.println(groupAnagramsNonOptimal(new String[]{"a", "b"}));
        System.out.println(groupAnagramsNonOptimal(new String[]{"", ""}));
        System.out.println(groupAnagramsNonOptimal(new String[]{""}));
        System.out.println("================================================");
        System.out.println(groupAnagrams(new String[]{"act","pots","tops","cat","stop","hat"}));
        System.out.println(groupAnagrams(new String[]{"cab","tin","pew","duh","may","ill","buy","bar","max","doc"}));
        System.out.println(groupAnagrams(new String[]{"x"}));
        System.out.println(groupAnagrams(new String[]{"a", "b"}));
        System.out.println(groupAnagramsNonOptimal(new String[]{"", ""}));
        System.out.println(groupAnagramsNonOptimal(new String[]{""}));
    }

    private static List<List<String>> groupAnagramsNonOptimal(String[] strs) { // O (n * m log m)
        Map<String, List<String>> results = new HashMap<>();
        for(String str: strs) { // O(n)
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray); // O(m log m)
            String sortedS = new String(charArray);
            results.computeIfPresent(sortedS, (key, set) -> {
                List<String> auxList = new ArrayList<>(set);
                auxList.add(str);
                return auxList;
            });
            results.computeIfAbsent(sortedS, key -> List.of(str));
        }
        return results.values()
            .stream()
            .map(result -> new ArrayList<>(result))
            .collect(Collectors.toList());
    }

    private static List<List<String>> groupAnagrams(String[] strs) { // O (n * m)
        Map<List<Integer>, List<String>> results = new HashMap<>();

        for(String str: strs) { // O(n)
            int[] alphabet = new int[26];
            for (char character : str.toCharArray()) { // O(m)
                alphabet[(int)character - 97]++;
            }
            List<Integer> alphabetKey = Arrays.stream(alphabet)
                .boxed()
                .collect(Collectors.toList());

            results.computeIfPresent(alphabetKey, (key, list) -> {
                List<String> auxList = new ArrayList<>(list);
                auxList.add(str);
                return auxList;
            });
            results.computeIfAbsent(alphabetKey, key -> List.of(str));
        }

        return results.values()
            .stream()
            .map(result -> new ArrayList<>(result))
            .collect(Collectors.toList());
    }
}
