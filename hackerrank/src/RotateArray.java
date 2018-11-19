public class RotateArray {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8};
        int d = 5;
        rotLeft(a, d);
    }

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int[] af = new int[a.length];
        int tmp;
        if(d > a.length-1) d = d - (a.length-1);
        for (int i=0; i<a.length; i++) {
            if(i+d < a.length)
                af[i] = a[i+d];
            else
                af[i] = a[Math.abs(a.length - i - d)];
        }
        for(int i=0; i<af.length;i++) {
            System.out.print(af[i]+ ", ");
        }
        return af;
    }
}
