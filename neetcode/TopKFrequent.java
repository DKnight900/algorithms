package neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TopKFrequent {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3},2))); // [1, 2]
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,1,2,2,3},2))); // [1, 2]
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,1},1))); // [1]
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,2},2))); // [1, 2]
    }

    private static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numsFrequencies = new HashMap<>();
        for (int num : nums) { // O(n); n -> nums length
            numsFrequencies.computeIfPresent(num, (key, frequency) -> numsFrequencies.get(key) + 1);
            numsFrequencies.putIfAbsent(num, 1);
        }

        List<Set<Integer>> numsByFrequencySet = IntStream.range(0, nums.length + 1)
            .mapToObj(i -> new HashSet<Integer>())
            .collect(Collectors.toList());

        for (int num: nums) {
            numsByFrequencySet.get(numsFrequencies.get(num)).add(num);
        }

        List<List<Integer>> numsByFrequency = numsByFrequencySet
            .stream()
            .map(set -> List.copyOf(set))
            .collect(Collectors.toList());

        List<Integer> results = new ArrayList<>(k);
        int l = 0;
        for  (int i = 0; i < numsByFrequency.size(); i++) {
            if (!numsByFrequency.get(numsByFrequency.size() - 1 - i).isEmpty()) {
                for (int j = 0; j < numsByFrequency.get(numsByFrequency.size() - 1 - i).size(); j++) {
                    results.add(numsByFrequency.get(numsByFrequency.size() - 1 - i).get(j));
                    l++;
                    if(l == k) {
                        return results
                            .stream()
                            .mapToInt(Integer::intValue)
                            .toArray();
                    }
                }
            }
        }
        return null;
    }
}
