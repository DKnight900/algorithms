package hackerrank;

public class RepeatedString {
    static long repeatedString(String s, long n) {
        long characterCount;
        long stringLength = s.length();

        long asInString = s.chars()
            .filter(ch -> ch == 'a')
            .count();
        characterCount = asInString * n / stringLength;
        System.out.println("n % stringLength:" + n % stringLength);
        System.out.println("characterCount:" + characterCount);
        characterCount += s.substring(0, (int)(n % stringLength))
            .chars()
            .filter(ch -> ch == 'a')
            .count();

        return characterCount;
    }

    public static void main(String[] args) {
//        System.out.println(repeatedString("aba", 10));
//        System.out.println(repeatedString("abac", 9));
//        System.out.println(repeatedString("a", 1000000000000L));
        System.out.println(repeatedString("epsxyyflvrrrxzvnoenvpegvuonodjoxfwdmcvwctmekpsnamchznsoxaklzjgrqruyzavshfbmuhdwwmpbkwcuomqhiyvuztwvq", 549382313570L));
    }
}
