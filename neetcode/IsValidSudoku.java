package neetcode;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku {
    public static void main(String[] args) {
//        System.out.println(isValidSudoku(new char[][] {
//            {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
//            {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
//            {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
//            {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
//            {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
//            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//            {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
//            {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
//            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        }));

//        System.out.println(isValidSudoku(new char[][] {
//            {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
//            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        }));
        System.out.println(isValidSudoku(new char[][] {
            {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
            {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
            {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
            {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
            {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
            {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
            {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        }));
    }

    private static boolean isValidSudoku(char[][] board) {

        if (rowCheckIsValid(board)) { // O(n^2)
            char[][] transpose = new char[board[0].length][board.length];
            for (int i = 0; i < board.length; i++) { // O(n^2)
                for (int j = 0; j < board[0].length; j++) {
                    transpose[j][i] = board[i][j];
                }
            }
            if (rowCheckIsValid(transpose)) { // O(n^2)
                Set<Character> submatrixElements;
                for (int k = 0; k < board.length; k += 3) {
                    for (int l = 0; l < board.length; l += 3) {
                        submatrixElements = new HashSet<>();
                        for (int i = k; i < (board.length / 3) + k; i++) { // O(n^2)
                            for (int j = l; j < (board[0].length / 3) + l; j++) {
                                if (submatrixElements.contains(board[i][j]) && board[i][j] != '.') {
                                    return false;
                                }
                                submatrixElements.add(board[i][j]);
                            }
                        }
                    }
                }
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
        return true;
    }

    private static boolean rowCheckIsValid(char[][] board) {
        Set<Character> rowElements;
        for (char[] row: board) {
            rowElements = new HashSet<>();
            for (char element: row) {
                if (rowElements.contains(element) && element != '.') {
                    return false;
                }
                rowElements.add(element);
            }
        }
        return true;
    }
}
