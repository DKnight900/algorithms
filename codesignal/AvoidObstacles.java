package codesignal;

public class AvoidObstacles {
    public static void main(String[] args) {
        AvoidObstacles avoidObstacles = new AvoidObstacles();
        int[] inputArray = {5, 3, 6, 7, 9};
//        int[] inputArray = {1, 4, 10, 6, 2};

        System.out.println(avoidObstacles.avoidObstacles(inputArray));
    }

    int avoidObstacles(int[] inputArray) {
        int j;
        for (int i = 2; i <= 1000; i++) {
            for (j = 0; j < inputArray.length; j++) {
                if (inputArray[j] % i == 0) {
                    break;
                }
            }
            if (j == inputArray.length) {
                return i;
            }
        }
        return 0;
    }
}
