package codesignal;

public class Candies {
    public static void main(String[] args) {
        System.out.println(Candies(3, 10));
        System.out.println(Candies(3, 11));
    }

    private static int Candies(int n, int m) {
        return (m / n) * n;
    }
}
