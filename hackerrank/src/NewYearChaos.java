public class NewYearChaos {
    public static void main(String[] args) {
        int[] q1 = {2,1,5,3,4};
        minimumBribes(q1);
        int[] q2 = {2,5,1,3,4};
        minimumBribes(q2);
    }

    public static void minimumBribes(int[] q) {
        int swap=0, chaos=0;
        boolean swaped = false;
        while (true) {
            for (int i=0; i<q.length; i++) {
                swaped = false;
                if (i + 1 < q.length) {
                    if (q[i] > q[i + 1]) {
                        int tmp = q[i];
                        q[i] = q[i + 1];
                        q[i + 1] = tmp;
                        swap++;
                        swaped = true;
                    }
                }
            }
            chaos++;
            for (int i=0; i<q.length; i++) System.out.print(q[i]+", ");
            System.out.println();
            if (chaos > 3) {
                if (chaos > 3) System.out.println("To chaotic");
                else System.out.println(swap);
                break;
            }
        }
    }
}
