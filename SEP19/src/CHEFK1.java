import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CHEFK1 {
    
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

    public static void main(String[] args) throws Exception {
        FastReader f = new FastReader();
        int t = f.nextInt();
        while (t-- > 0) {
            long n = f.nextLong();
            long m = f.nextLong();
            if (n == 1) {
                if (m == 1) {
                    System.out.println(1);
                } else if (m == 0) {
                    System.out.println(0);
                } else {
                    System.out.println(-1);
                }
            } else if (n == 2) {
                if (m == 1) {
                    System.out.println(1);
                } else if (m == 2 || m == 3) {
                    System.out.println(2);
                } else {
                    System.out.println(-1);
                }
            } else {
                if ((n - m >= 2 || m > (n * (n - 1)) / 2 + n)) {
                    System.out.println(-1);
                } else {
                    if (m <= n + 1) {
                        System.out.println(2);
                    } else if (m <= 2 * n) {
                        System.out.println(3);
                    } else {
                        long deg = (2 * (m - n)) / n;
                        long rem = (2 * (m - n)) - deg * n;
                        if (rem == 0) {
                            System.out.println(deg + 1);
                        } else {
                            System.out.println(deg + 2);
                        }
                    }
                }
            }

        }

    }
}
