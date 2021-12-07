package hackerrank;

public class CountingValleys {
    static int countingValleys(int n, String s) {
        char upOrDown;
        int numberOfValleys = 0;
        int path = 0;

        for(int i = 0; i < n; i++) {
            upOrDown = s.charAt(i);
            if(path == 0 && upOrDown == 'D') {
                numberOfValleys++;
            }
            path = upOrDown == 'D' ? --path : ++path;
        }
        return numberOfValleys;
    }

    public static void main(String[] args) {
        System.out.println(countingValleys(8,"DDUUUUDD"));
        System.out.println(countingValleys(8,"UDDDUDUU"));
    }
}
