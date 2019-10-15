import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class RSIGNS {
    
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
        final int MAX = 1000000007;
        //long time = System.currentTimeMillis();
        while (t-- > 0) {
            int k = f.nextInt() - 1;
            long total = 1L;
            long x = 2;
            while (k > 0) {
                if ((k & 1) == 1) {
                    total = (total * x) % MAX;
                }
                
                k = k >> 1;
                x = (x * x) % MAX;
            }
            total = (total * 10) % MAX;
            System.out.println(total);
        }
        //System.out.println(System.currentTimeMillis() - time);
    }

}
