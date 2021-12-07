package codesignal;

public class SpiralNumbers {
  public static void main(String[] args) {
    System.out.println(spiralNumbers(4));
  }
  private static int[][] spiralNumbers(int n) {
    int[][] spiralMatrix = new int[n][n];
    int initColumn = 0;
    int endColumn = n;
    int initRow = 0;
    int endRow = n;
    int currentValue = 1;

    while (currentValue <= n * n) {
      for (int j = initColumn; j < endColumn; j++) {
        spiralMatrix[initRow][j] = currentValue++;
      }
      initRow++;
      for (int i = initRow; i < endRow; i++) {
        spiralMatrix[i][endColumn - 1] = currentValue++;
      }
      endColumn--;
      for (int j = endColumn - 1; j >= initColumn; j--) {
        spiralMatrix[endRow - 1][j] = currentValue++;
      }
      endRow--;
      for (int i = endRow - 1; i >= initRow; i--) {
        spiralMatrix[i][initColumn] = currentValue++;
      }
      initColumn++;
    }

    return spiralMatrix;
  }
}
