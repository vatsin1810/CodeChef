import java.math.BigInteger;
import java.util.Random;

 

public class Trial {
    static int MIN = Integer.MAX_VALUE;
    static boolean[] seen;
    
    public static void findmininit (int z, int k, int n) {
        MIN = Integer.MAX_VALUE;
        seen = new boolean[n + 1];
        findmin(z, k, n);
    }
    
    public static void findmin(int z, int k, int n) {
        if (seen[z]) {
            return;
        }
        if (z < MIN) {
            MIN = z;
        }
        int max = Math.min(z, k);
        int min = Math.max(0, k - (n - z));
        seen[z] = true;
        for (int i = min; i <= max; i++) {
            if (z + k - 2 * i <= n) {
                findmin(z + k - 2 * i, k, n);
            }
        }
    }

    public static void main(String[] args) {
        findmininit(3, 9, 11);
        for (int i = 0; i < seen.length; i++) {
            if (seen[i]) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }
        }
    }

}

