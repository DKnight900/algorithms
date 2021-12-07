package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SherlockAndAnagrams {

    static int sherlockAndAnagrams(String s) {
        List<List<String>> stringCombinations = new ArrayList<>();
        String element;
        List<String> possibilitiesGivenALength;
        int samePairs = 0;

        for (int positionLength = 1; positionLength < s.length(); positionLength++) {
            possibilitiesGivenALength = new ArrayList<>();
            for (int j = 0; j < s.length() - positionLength + 1; j++) {
                element = "";
                for (int i = 0; i < positionLength; i++) {
                    element += s.charAt(j + i);
                }
                char[] tempCharacters = element.toCharArray();
                Arrays.sort(tempCharacters);
                element = new String(tempCharacters);
                possibilitiesGivenALength.add(element);
            }
            stringCombinations.add(possibilitiesGivenALength);
        }
        for (int i = 0; i < stringCombinations.size(); i++) {
            List<String> currentArray = stringCombinations.get(i);
            for (int j = 0; j < currentArray.size(); j++) {
                for (int k = j + 1; k < currentArray.size(); k++) {
                    if (currentArray.get(j).equals(currentArray.get(k))) {
                        samePairs++;
                    }
                }
            }
        }
        return samePairs;
    }

    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("abcd"));
        System.out.println(sherlockAndAnagrams("kkkk"));
        System.out.println(sherlockAndAnagrams("ifailuhkqq"));
    }
}
