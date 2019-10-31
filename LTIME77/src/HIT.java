import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HIT {
    
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
            for (int i = 0; i < n; i++) {
                a[i] = f.nextInt();
            }
            Arrays.sort(a);
            if (n == 4 && a[0] != a[1] && a[1] != a[2] && a[2] != a[3]) {
                System.out.println(a[1] + " " + a[2] + " " + a[3]);
            } else if (n != 4 && a[n / 4] != a[n / 4 - 1] 
                    && a[n / 2] != a[n / 2 - 1]
                    && a[(3 * n) / 4] != a[(3 * n) / 4 - 1]) {
                System.out.println(a[n/4] + " " + a[n/2] + " " + a[(3 * n) / 4]);
            } else {
                System.out.println(-1);
            }
        }

    }

}
