import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{5, 5}, 10)));
        System.out.println(Arrays.toString(twoSum(new int[]{4, 5, 6}, 10)));
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> existence = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            existence.put(nums[i], i);
        }
        int secondDigitSum;
        int j;
        for (int i = 0; i < nums.length; i++) {
            secondDigitSum = target - nums[i];
            if (existence.containsKey(secondDigitSum)) {
                j = existence.get(secondDigitSum);
                if (i != j) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
