import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LENTMO {
    
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

    public static void main(String[] args) {
        FastReader f = new FastReader();
        int t = f.nextInt();
        while (t-- > 0) {
            int n = f.nextInt();
            int[] a = new int[n];
            boolean[] b = new boolean[n];
            for (int i = 0; i < n; i++) {
                a[i] = f.nextInt();
            }
            int k = f.nextInt();
            int x = f.nextInt();
            int s1s = 0;
            for (int i = 0; i < n; i++) {
                if ((a[i] ^ x) > a[i]) {
                    b[i] = true;
                    s1s++;
                }
            }
            if (k == n) {
                long sum1 = 0;
                long sum2 = 0;
                for (int i = 0; i < n; i++) {
                    sum1 += (long) a[i];
                    sum2 += (long) (a[i] ^ x);
                }
                System.out.println(Math.max(sum1, sum2));
            } else {
                long sum = 0;
                for (int i = 0; i < n; i++) {
                    if (b[i]) {
                        sum += (long) (a[i] ^ x);
                    } else {
                        sum += (long) a[i];
                    }
                }
                if (s1s % 2 == 0 || (s1s % 2 == 1 && k % 2 == 1)) {
                    System.out.println(sum);
                } else {
                    long min = Long.MAX_VALUE;
                    for (int i = 0; i < n; i++) {
                        if (Math.abs(a[i] - (a[i] ^ x)) < min) {
                            min = (long) Math.abs(a[i] - (a[i] ^ x));
                        }
                    }
                    System.out.println(sum - min);
                }
            }
        }

    }

}
