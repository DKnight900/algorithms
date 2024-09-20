package codesignal;

public class LateRide {
    public static void main(String[] args) {
        System.out.println(LateRide(240));  // 4 --> 04:00
        System.out.println(LateRide(1440)); // 0
        System.out.println(LateRide(1380)); // 5 --> 23:00
        System.out.println(LateRide(1381)); // 6 --> 23:01
        System.out.println(LateRide(1439)); // 19 --> 23:59
    }
    private static int LateRide(int n) {
        if (n == 1440) {
            return 0;
        }
        int minutes = n % 60;
        int hours = n / 60;

        return (hours / 10) + (hours % 10) + (minutes / 10) + (minutes % 10);
    }
}
