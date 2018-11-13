import java.io.IOException;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Scanner;

public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int max = 0, count = 0;
        for (int i=0; i<n; i++) {
            if (ar[i] > max) max = ar[i];
        }
        BitSet pairs = new BitSet(max);
        for (int i=0; i<n; i++) {
            if (pairs.get(ar[i])) {
                pairs.clear(ar[i]);
                count++;
            } else {
                pairs.set(ar[i]);
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
        System.out.print(result);
        scanner.close();
    }
}
