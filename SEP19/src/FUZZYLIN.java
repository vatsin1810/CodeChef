import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FUZZYLIN {
    
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
    
    public static int gcd(int a, int b) {
        while (a > 0) {
            int temp = b;
            b = a;
            a = temp % a;
        }
        
        return b;
    }

    public static void main(String[] args) {
        FastReader f = new FastReader();
        int n = f.nextInt();
        int[] a = new int[n];
        int[][] gcda = new int[n][n];
        for (int i = 0; i < n; i++) {
            a[i] = f.nextInt();
            gcda[i][i] = a[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                gcda[i][j] = gcd(gcda[i][j - 1], a[j]);
            }
        }
        int q = f.nextInt();
        for (int i = 0; i < q; i++) {
            long total = 0;
            int k = f.nextInt();
            for (int j = 0; j < n; j++) {
                for (int l = j; l < n; l++) {
                    if (k % gcda[j][l] == 0) {
                        total++;
                    }
                }
            }
            System.out.println(total);
        }
        

    }

}
