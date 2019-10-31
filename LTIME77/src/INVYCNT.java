import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class INVYCNT {
    
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
        while (t -- > 0) {
            int n = f.nextInt();
            long k = f.nextLong();
            int[] a = new int[n];
            long totalinv = 0L;
            for (int i = 0; i < n; i++) {
                a[i] = f.nextInt();
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (a[i] > a[j]) {
                        totalinv += k;
                    }
                }
            }
            Arrays.sort(a);
            int currentind = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] != a[currentind]) {
                    currentind = i;
                }
                totalinv += (currentind * k * (k - 1)) / 2;
            }
            System.out.println(totalinv);
        }

    }

}
