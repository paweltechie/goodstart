public class NewYearChaos {
    public static void main(String[] args) {
        int[] q1 = {2,1,5,3,4};
        minimumBribes(q1);
        int[] q2 = {2,5,1,3,4};
        minimumBribes(q2);
    }

    public static void minimumBribes(int[] q) {
        int swap=0, oneSwap=0;
        boolean chaos = false;
        while (true) {
            for (int i=0; i<q.length; i++) {
                if (i + 1 < q.length) {
                    if (q[i] > q[i + 1]) {
                        int tmp = q[i];
                        q[i] = q[i + 1];
                        q[i + 1] = tmp;
                        oneSwap++;
                        swap++;
                        if (oneSwap > 2) {
                            chaos = true;
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
            for (int i=0; i<q.length; i++) System.out.print(q[i]+", ");
            System.out.println();
        }
        if (chaos)
            System.out.println("To chaotic");
        else
            System.out.println(swap);
        }
    }
}
