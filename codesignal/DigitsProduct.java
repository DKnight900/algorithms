package codesignal;

public class DigitsProduct {
  public static void main(String[] args) {
//    System.out.println(digitsProduct(450));
//    System.out.println(digitsProduct(243));
    System.out.println(digitsProduct(1));
  }
  private static int digitsProduct(int product) {
    String result = "";
    int i;
    if (product < 10) {
      return product == 1 ? 1 : product + 10;
    }
    i = 9;
    while(i > 1) {
      if (product % i == 0) {
        product /= i;
        result = i + result;
        i = 9;
      }
      else {
        i--;
      }
    }

    return product > 10 || result.equals("") ? -1 : Integer.parseInt(result);
  }
}
