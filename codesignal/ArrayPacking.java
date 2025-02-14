package codesignal;

public class ArrayPacking {
    public static void main(String[] args) {
        System.out.println(ArrayPacking(new int[]{24, 85, 0}));
    }

    private static int ArrayPacking(int[] a) {
        StringBuilder M = new StringBuilder();
        for (int i = a.length -1; i>=0; i--) {
            M.append(String.format("%08d", Integer.parseInt(Integer.toBinaryString(a[i]))));
        }
        return Integer.parseInt(M.toString(), 2);
    }
}
