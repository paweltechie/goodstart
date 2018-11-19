import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HourglassSearch {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("inputData.txt"));
        int[][] arr = new int[6][6];
        for (int i=0; i<11; i++) {
            scanner.nextLine();
        }
        System.out.println(scanner.nextLine());
        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(",");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
//                System.out.print(arrItem);
            }
        }
        System.out.print(hourglassSum(arr));
    }

    static long hourglassSum(int[][] arr) {
        int y=0, x=0;
        long sum=0, newSum=0;
        boolean second = false;
        while (y + 2 < 6) {
            x = 0;
            while (x + 2 < 6) {
                System.out.println("|" + arr[y][x] + "|" + arr[y][x + 1] + "|" + arr[y][x + 2]);
                System.out.println("  " + arr[y + 1][x + 1] + "  ");
                System.out.println("|" + arr[y + 2][x] + "|" + arr[y + 2][x + 1] + "|" + arr[y + 2][x + 2]);

                newSum = arr[y][x] + arr[y][x + 1] + arr[y][x + 2] + arr[y + 1][x + 1] + arr[y + 2][x] + arr[y + 2][x + 1] + arr[y + 2][x + 2];

                System.out.println("sum "+newSum);
                x++;
                if (second) {
                    if (newSum > sum) sum = newSum;
                } else {
                    sum = newSum;
                    second = true;
                }
            }
            y++;
        }
        return sum;
    }

}
