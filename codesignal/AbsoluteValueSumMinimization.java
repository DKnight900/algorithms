package codesignal;

public class AbsoluteValueSumMinimization {
    public static void main(String[] args) {
        AbsoluteValueSumMinimization absoluteValueSumMinimization = new AbsoluteValueSumMinimization();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 15, 16, 17, 18};
        System.out.println(absoluteValueSumMinimization.absoluteValuesSumMinimization(a));
    }

    int absoluteValuesSumMinimization(int[] a) {
        int lowestSum = sumForX(a, a[0]);
        int xMin = a[0];
        int sumForX;
        for (int i = 0; i < a.length; i++) {
            sumForX = sumForX(a, a[i]);
            if (sumForX <= lowestSum) {
                if (sumForX == lowestSum) {
                    xMin = xMin > a[i] ? a[i] : xMin;
                }
                else {
                    xMin = a[i];
                    lowestSum = sumForX;
                }
            }
        }

        return xMin;
    }

    int sumForX(int[] a, int x) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += Math.abs(a[i] - x);
        }
        return sum;
    }
}
