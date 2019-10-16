import java.util.Scanner;

public class P2 {
    
    public static String trimDigit (String s, int d) {
        String res = "";
        int i = 1;
        int length = s.length();
        while (i < d) {
            int x = s.indexOf(Character.forDigit(i, 10));
            if (x == -1) {
                i++;
            } else {
                res += Character.forDigit(i, 10);
                s = s.substring(x + 1);
            }
        }
        int lengthf = res.length();
        for (int j = lengthf; j < length; j++) {
            res += Character.forDigit(d, 10);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            Long n = s.nextLong();
            String f = n.toString();
            int d = s.nextInt();
            System.out.println(trimDigit(f, d));
        }
        s.close();
    }

}
