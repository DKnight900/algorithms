package codesignal;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(LargestNumber(1)); // 9
        System.out.println(LargestNumber(2)); // 99
        System.out.println(LargestNumber(9)); // 999999999
    }

    private static int LargestNumber(int n) {
        String numberWithZeros = String.valueOf((int)Math.pow(10, n));
        String numberWithNines = numberWithZeros
            .chars()
            .map(digit -> 9)
            .boxed()
            .map(Object::toString)
            .collect(Collectors.joining());
        return Integer.parseInt(numberWithNines.substring(0, numberWithNines.length() - 1));

    }
}
