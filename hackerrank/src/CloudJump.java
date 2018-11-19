import java.util.Scanner;

public class CloudJump {
    public static void main(String args[]) {
//        int[] c = {0,0,1,0,0,1,0};
//        int[] c = {0,0,0,1,0,0};
//        int[] c = {0,0,1,0,0,1,0};
        int[] c = {0,0,0,1,0,0};
        System.out.print(jumpingOnClouds(c));
    }

    public static int jumpingOnClouds(int[] c) {
        int step = 0;
        for (int i=1; i<c.length; i++) {
            if (i + 1 < c.length) {
                if (c[i+1] == 0) {
                    step++;
                    i += 1;
                } else {
                    step++;
                }
            } else {
                step++;
            }
        }
        return step;
    }
}
