package codesignal;

public class PhoneCall {
    public static void main(String[] args) {
        System.out.println(PhoneCall(3, 1, 2, 20)); // 14
        System.out.println(PhoneCall(10, 1, 2, 22)); // 11
        System.out.println(PhoneCall(10, 10, 10, 8)); // 0
    }

    private static int PhoneCall(int min1, int min2_10, int min11, int s) {
        for (int minutesPassed = 1; ; minutesPassed++) {
            if (minutesPassed <= 1) {
                s -= min1;
                if (s < 0) {
                    return minutesPassed - 1;
                } else if (s == 0) {
                    return minutesPassed;
                }
                continue;
            }
            if (minutesPassed <= 10) {
                s -= min2_10;
                if (s < 0) {
                    return minutesPassed - 1;
                } else if (s == 0) {
                    return minutesPassed;
                }
                continue;
            }
            s -= min11;
            if (s < 0) {
                return minutesPassed - 1;
            } else if (s == 0) {
                return minutesPassed;
            }
        }
    }
}
