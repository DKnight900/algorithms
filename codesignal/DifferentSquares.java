package codesignal;

import java.util.*;

public class DifferentSquares {
  public static void main(String[] args) {
    int[][] matrix = { { 1, 2, 1}, { 2, 2, 2}, {2, 2, 2}, {1, 2, 3}, {2, 2, 1} };
    System.out.println(differentSquares(matrix));
  }
  static int differentSquares(int[][] matrix) {
    Set<List<Integer>> differentSquares = new HashSet<>();
    List<Integer> square;
    for (int i = 0; i < matrix.length - 1; i++) {
      for (int j = 0; j < matrix[i].length - 1; j++) {
        square = new ArrayList<>();
        square.add(matrix[i][j]);
        square.add(matrix[i][j + 1]);
        square.add(matrix[i + 1][j]);
        square.add(matrix[i + 1][j + 1]);
        differentSquares.add(square);
      }
    }
    return differentSquares.size();
  }
}
