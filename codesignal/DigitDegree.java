package codesignal;

public class DigitDegree {
    public static void main(String[] args) {
        System.out.println(digitDegree(5));
    }

    private static int digitDegree(int n) {
        return digitDegreeWithStackCounter(n, 1);
    }

    private static int digitDegreeWithStackCounter(int n, int times) {
        String nString = String.valueOf(n);
        int sum = 0;
        for(Character character: nString.toCharArray()) {
            sum += Character.getNumericValue(character);
        }
        if (sum < 10) {
            return times;
        }
        return digitDegreeWithStackCounter(sum, times + 1);
    }
}
