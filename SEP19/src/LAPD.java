import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class LAPD {
    
    static class FastReader { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() { 
            while (st == null || !st.hasMoreElements()) { 
                try { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() { 
            String str = ""; 
            try { 
                str = br.readLine(); 
            } 
            catch (IOException e) { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }
    
    public static LinkedList<Integer> primeFactors(int f) {
        LinkedList<Integer> factors = new LinkedList<>();
        while ((f & 1) == 0) {
            f = f >> 1;
            factors.add(2);
            factors.add(2);
        }
        for (int i = 3; i * i <= f; i += 2) {
            while (f % i == 0) {
                f /= i;
                factors.add(i);
                factors.add(i);
            }
        }
        factors.add(f);
        factors.add(f);
        return factors;
    }

    public static void main(String[] args) {
        FastReader f = new FastReader();
        int t = f.nextInt();
        long max = 1000000007L;
        while (t-- > 0) {
            int A = f.nextInt();
            int B = f.nextInt();
            int C = f.nextInt();
            long[] dp = new long[B + 1];
            long total = 0L;
            dp[B] = (((long) Math.max(A - B - 1, 0)) * ((long) Math.max(C - B - 1, 0)));
            long B2 = B * B;
            for (int i = 1; i <= Math.min(C - 1, B); i++) {
                dp[B] += Math.max(A - B2 / i - 1, 0L);
                if (i <= A - 1) {
                    dp[B] += Math.max(C - B2 / i - 1, 0L);
                }
            }
            total = dp[B] % max;
            for (int b = B - 1; b >= 1; b--) {
                dp[b] = dp[b + 1];
                LinkedList<Integer> l = primeFactors(b + 1);
                
//                total = (total + (((long) Math.max(A - b - 1, 0)) * ((long) Math.max(C - b - 1, 0)))) % max;
//                long b2 = b * b;
//                for (int i = 1; i <= Math.min(C - 1, b); i++) {
//                    total = (total + Math.max(A - b2 / i - 1, 0L)) % max;
//                    if (i <= A - 1) {
//                        total = (total + Math.max(C - b2 / i - 1, 0L)) % max;
//                    }
//                }
            }
            System.out.println(total);
        }
    }
}
