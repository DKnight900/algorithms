package codesignal;

public class BishopAndPawn {
    public static void main(String[] args) {
        System.out.println(bishopAndPawn("a1", "c3"));
    }

    static boolean bishopAndPawn(String bishop, String pawn) {
        int bishopX = bishop.charAt(0) - 97;
        int bishopY = bishop.charAt(1) - 1;
        int pawnX = pawn.charAt(0) - 97;
        int pawnY = pawn.charAt(1) - 1;

        int distanceX = Math.abs(pawnX - bishopX);
        int distanceY = Math.abs(pawnY - bishopY);
        double angle = Math.toDegrees(Math.atan(distanceY / (double)distanceX));

        return angle == 45.0;
    }
}
