import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOXGAM97 {
    
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
            int k = f.nextInt();
            int p = f.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = f.nextInt();
            }
            if (p == 0 && k % 2 == 1) {
                int max = 0;
                for (int i = 0; i < n; i++) {
                    if (a[i] > max) {
                        max = a[i];
                    }
                }
                System.out.println(max);
            } else if (p == 0 && k % 2 == 0) {
                int maxval = 0;
                if (a[1] > a[n - 2]) {
                    maxval = a[1];
                } else {
                    maxval = a[n - 2];
                }
                for (int i = 1; i < n - 1; i++) {
                    if (Math.min(a[i - 1], a[i + 1]) > maxval) {
                        maxval = Math.min(a[i - 1], a[i + 1]);
                    }
                }
                System.out.println(maxval);
            } else if (p == 1 && k % 2 == 1) {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    if (a[i] < min) {
                        min = a[i];
                    }
                }
                System.out.println(min);
            } else {
                int minval = Integer.MAX_VALUE;
                if (a[1] < a[n - 2]) {
                    minval = a[1];
                } else {
                    minval = a[n - 2];
                }
                for (int i = 1; i < n - 1; i++) {
                    if (Math.max(a[i - 1], a[i + 1]) < minval) {
                        minval = Math.max(a[i - 1], a[i + 1]);
                    }
                }
                System.out.println(minval);
            }
        }
    }

}
