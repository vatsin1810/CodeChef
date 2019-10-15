import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CHFWAR {
    
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
            int[] a = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                a[i] = f.nextInt();
            }
            int fi = f.nextInt();
            long min = Long.MAX_VALUE;
            int minp = 0;
            for (int i = 0; i < n - 1; i++) {
                if (a[i] > fi) {
                    continue;
                }
                
                long total = 0;
                int size;
                int last;
                int dist;
                if (i % 2 == 1) {
                    total += (long) a[i - 1];
                    size =  n - 1 - ((i - 1) / 2);
                    last = i - 1;
                    dist = i - 1 == 0 ? 1 : 2;
                } else {
                    size = n - 1 - (i / 2);
                    last = i == 0 ? n - 2 : i - 2;
                    dist = i == 0 ? 1 : 2;
                }
                while (size > 1) {
                    if (size % 2 == 0) {
                        if (last - dist < 0) {
                            //last = last - dist + n - 1;
                            int off = (((n - 2) % dist) - (i % dist));
                            if (off < 0) {
                                last = n - 2 - (off + dist);
                            } else {
                                last = n - 2 - off;
                            }
                        } else {
                            last = last - dist;
                            dist = dist << 1;
                        }
                        size = size >> 1;
                        
                    } else {
                        total += (long) a[last];
                        size++;
                        size = size >> 1;
                        dist = dist << 1;
                    }
                    
                }
                if (total + (long) fi < min) {
                    min = total + (long) fi;
                    minp = i + 1;
                }
            }
            if (min == Long.MAX_VALUE) {
                System.out.println("impossible");
            } else {
                System.out.println("possible");
                System.out.println(minp + " " + min);
            }
            
        }

    }

}
