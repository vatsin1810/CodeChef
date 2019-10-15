import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class MSV {
    
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
            int[] r = new int[n];
            HashMap<Integer, Integer> h = new HashMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = f.nextInt();
                h.put(a[i], i);
            }
            for (int i = 0; i < n; i++) {
                int temp = a[i];
                for (int j = 1; j * j <= temp; j++) {
                    if (temp % j == 0 && h.containsKey(j) && h.get(j) > i) {
                        r[h.get(j)]++;
                    }
                    if (temp % j == 0 && temp != j * j && 
                            h.containsKey(temp / j) && h.get(temp / j) > i) {
                        r[h.get(temp / j)]++;
                    }
                }
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (r[i] > max) {
                    max = r[i];
                }
            }
            System.out.println(max);
        }

    }

}
