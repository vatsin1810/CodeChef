import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PROXYC {
    
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
            int d = f.nextInt();
            String s = f.next();
            int total = 0;
            int proxy = 0;
            for (int i = 0; i < d; i++) {
                if (s.charAt(i) == 'P') {
                    total++;
                }
            }
            for (int i = 2; i < d - 2; i++) {
                if (s.charAt(i) == 'A' 
                        && (s.charAt(i - 1) == 'P' || s.charAt(i - 2) == 'P') 
                        && (s.charAt(i + 1) == 'P' || s.charAt(i + 2) == 'P')) {
                    proxy++;
                }
            }
            if (total + proxy >= 0.75 * (double) d) {
                System.out.println(Math.max(((int) (0.75 * (double) d + 0.75)) - total, 0));
            } else {
                System.out.println(-1);
            }
        }
    }

}
