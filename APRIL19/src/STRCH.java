import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class STRCH {
    
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
        for (int z = 0; z < t; z++) {
            long n = f.nextInt();
            StringBuilder str = new StringBuilder(f.next());
            char ch = f.next().charAt(0);
            long count = 0;
            long total = 0;
            for (int i = 0; i < n; i++) {
                if (str.charAt(i) == ch) {
                    total += (count + 1) * (n - ((long) i));
                    count = 0;
                } else {
                    count++;
                }
            }
            System.out.println(total);
        }

    }

}
