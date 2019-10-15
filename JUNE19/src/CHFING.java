import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CHFING {
    
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
        int MAX = 1000000007;
        while (t-- > 0) {
            long n = f.nextLong();
            long k = f.nextLong();
            long last = (k - 1);
            long first = ((k - 1) % (n - 1));
            long no = (k - 1) / (n - 1) + 1;
            int ans;
            if (no % 2 == 0) {
                ans = (int) ((((no / 2) % MAX) * ((last + first) % MAX)) % MAX);
            } else {
                ans = (int) (((no % MAX) * (((last + first) / 2) % MAX)) % MAX);
            }
            System.out.println(ans);
        }
    }

}
