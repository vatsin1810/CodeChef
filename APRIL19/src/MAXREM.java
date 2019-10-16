import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MAXREM {
    
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
        int n = f.nextInt();
        int a = f.nextInt();
        int max = a;
        int count = 1;
        int smax = 0;
        while (count < n && (smax = f.nextInt()) == a) { count++; }
        if (count == n) {
            System.out.println(0);
        } else {
            if (max < smax) {
                int temp = max;
                max = smax;
                smax = temp;
            }
            for (int i = 0; i < n - count - 1; i++) {
                int t = f.nextInt();
                if (t > max) {
                    smax = max;
                    max = t;
                } else if (t > smax && t != max) {
                    smax = t;
                }
            }
            System.out.println(smax);
        }

    }

}
