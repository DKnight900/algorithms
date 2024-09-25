package codesignal;

public class KnapsackLight {
    public static void main(String[] args) {
        System.out.println(KnapsackLight(10, 5, 6, 4, 8)); // 10
        System.out.println(KnapsackLight(10, 5, 6, 4, 9)); // 16
        System.out.println(KnapsackLight(5, 3, 7, 4, 6)); // 7
        System.out.println(KnapsackLight(15, 2, 20, 3, 2)); // 15
        System.out.println(KnapsackLight(15, 2, 20, 1, 2)); // 20
        System.out.println(KnapsackLight(10, 2, 11, 3, 1)); // 0
        System.out.println(KnapsackLight(15, 2, 20, 4, 3)); // 15
    }

    private static int KnapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
        if (weight1 + weight2 <= maxW) {
            return value1 + value2;
        }
        if (weight1 > maxW && weight2 > maxW) {
            return 0;
        }
        if (weight1 > maxW) {
            return value2;
        }
        if (weight2 > maxW) {
            return value1;
        }
        return Math.max(value1, value2);
    }
}
