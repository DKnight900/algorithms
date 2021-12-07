package hackerrank;

public class JumpingOnTheClouds {

    static int jumpingOnClouds(int[] c) {
        int jumpLength;
        int jumps = 0;
        for (int pointer = 0; pointer < c.length - 1; pointer += jumpLength) {
            if (pointer + 2 == c.length) {
                jumps++;
                break;
            }
            jumpLength = c[pointer + 2] == 0 ? 2: 1;
            jumps++;
        }

        return jumps;
    }

    public static void main(String[] args) {
        int clouds[][] = {
            {0, 0, 1, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0, 1, 0}
        };
        for (int i = 0; i < clouds.length; i++) {
            System.out.println(jumpingOnClouds(clouds[i]));
        }
    }
}
