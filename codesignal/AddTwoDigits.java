package codesignal;

public class AddTwoDigits {
    public static void main(String[] args) {
        System.out.println(addTwoDigits(58));
        System.out.println(addTwoDigits(99));
        System.out.println(addTwoDigits(10));
        System.out.println(addTwoDigits(34));
    }

    private static int addTwoDigits(int n) {
        return (n / 10) + (n % 10);
    }
}
