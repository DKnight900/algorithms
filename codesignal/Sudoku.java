package codesignal;

import java.util.HashMap;
import java.util.Map;

public class Sudoku {
    public static void main(String[] args) {
        System.out.println(sudoku((new int[][] {
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {9, 1, 2, 3, 4, 5, 6, 7, 8}
        })));

        System.out.println(sudoku((new int[][]{
            {1, 3, 2, 5, 4, 6, 9, 8, 7},
            {4, 6, 5, 8, 7, 9, 3, 2, 1},
            {7, 9, 8, 2, 1, 3, 6, 5, 4},
            {9, 2, 1, 4, 3, 5, 8, 7, 6},
            {3, 5, 4, 7, 6, 8, 2, 1, 9},
            {6, 8, 7, 1, 9, 2, 5, 4, 3},
            {5, 7, 6, 9, 8, 1, 4, 3, 2},
            {2, 4, 3, 6, 5, 7, 1, 9, 8},
            {8, 1, 9, 3, 2, 4, 7, 6, 5}
        })));
    }
    private static boolean sudoku(int[][] grid) {
        Map<Integer, Integer> current;
        int sum;
        for (int i = 0; i < 9; i++) {
            sum = 0;
            for (int j = 0; j < 9; j++) {
                sum += grid[i][j];
            }
            if (sum != 45) {
                return false;
            }
        }
        for (int j = 0; j < 9; j++) {
            sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += grid[i][j];
            }
            if (sum != 45) {
                return false;
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                current = new HashMap<>();
                for(int m = 1; m <= 9; m++) {
                    current.put(m, 0);
                }
                for(int k = i; k < i + 3; k++) {
                    for(int l = j; l < j + 3; l++) {
                        if (current.get(grid[k][l]) == 1) {
                            return false;
                        }
                        current.put(grid[k][l], 1);
                    }
                }
            }
        }
        return true;
    }
}
