public class ContingValleys {
    public static void main(String[] args) {
        int n = 8;
        String arr = "UDDDUDUU";
        int v=0, h=0, countV = 0;
        for (int i=0; i<n; i++) {
            String step = arr.substring(i, i+1);
            if(v > h) {
                if (step.equals("U")) v--;
                if (step.equals("D")) v++;
                if (v == 0) {
                    countV++;
                }
            } else if(h > v) {
                if(step.equals("U")) h++;
                if(step.equals("D")) h--;
            } else if (v+h == 0) {
                if (step.equals("D")) {
                    v++;
                } else {
                    h++;
                }
            }
        }
        System.out.print(countV);
    }
}
