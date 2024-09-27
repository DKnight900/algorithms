package codesignal;

public class TennisSet {
    public static void main(String[] args) {
        System.out.println(TennisSet(3, 6)); // true
        System.out.println(TennisSet(8, 5)); // false
        System.out.println(TennisSet(0, 6)); // true
        System.out.println(TennisSet(5, 0)); // false
        System.out.println(TennisSet(5, 6)); // false
        System.out.println(TennisSet(7, 2)); // false
    }

    private static boolean TennisSet(int score1, int score2) {
        if (Math.max(score1, score2) < 6) {
            return false;
        }
        if (score1 + score2 >= 11 && score1 + score2 < 13 && Math.abs(score1 - score2) < 2) {
            return false;
        }
        if(score1 + score2 > 13) {
            return false;
        }
        if ((score1 >= 7 || score2 >= 7) && Math.abs(score1 - score2) > 2) {
            return false;
        }
        return true;
    }
}
