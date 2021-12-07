package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DKnight900
 * 
 * Given an array of strings, group anagrams together.
 *
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 *  Return:
 *
 *  [
 *      ["ate", "eat","tea"],
 *      ["nat","tan"],
 *      ["bat"]
 *  ]
 * 
 */
public class GroupAnagrams {
    
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
    
    private static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());               
            }
            map.get(key).add(str);                            
        }
        return new ArrayList<>(map.values());
    }
} 
   
