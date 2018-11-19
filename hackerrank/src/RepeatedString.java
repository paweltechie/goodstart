public class RepeatedString {
    public static void main(String[] args) {
        String s = "ada";
        long n = 10;
        System.out.print(repeatedString(s, n));
    }

    static long repeatedString(String s, long n) {
        char match = 'a';
        long count=0;
        for (int i=0; i<s.length(); i++) {
            if(s.charAt(i) == match) count++;
        }
        long multiplier = n/s.length() + 1;
        long remainder = s.length() * multiplier - n;
        multiplier--;
        count = count * multiplier;
        if (remainder > 0) {
            for (int i=0; i<s.length()-remainder; i++) {
                if(s.charAt(i) == match) count++;
            }
        }
        return count;
    }
}
