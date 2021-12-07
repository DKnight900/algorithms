package codesignal;

public class ChessKnight {
    public static void main(String[] args) {
        System.out.println(chessKnight("a1"));
    }

    static int chessKnight(String cell) {
        int knightX = cell.charAt(0) - 97;
        int knightY = Character.getNumericValue(cell.charAt(1)) - 1;

        if ((knightX >= 2 && knightX <= 5) && (knightY >= 2 && knightY <= 5)) {
            return 8;
        }

        if (((knightX >= 2 && knightX <= 5) && (knightY == 1 || knightY == 6)) ||
        ((knightX == 1 || knightX == 6) && (knightY >= 2 && knightY <= 5))) {
            return 6;
        }

        if (((knightY == 0 || knightY == 7) && (knightX == 1 || knightX == 6)) || ((knightY == 1 || knightY == 6) && (knightX == 0 || knightX == 7))){
            return 3;
        }

        if ((knightX == 0 || knightX == 7) && (knightY == 0 || knightY == 7)) {
            return 2;
        }

        return 4;
    }
}
