import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SUMAGCD {
    
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
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        FastReader f = new FastReader();
        int t = f.nextInt();
        while (t-- > 0) {
            int n = f.nextInt();
            HashSet<Integer> h = new HashSet<>();
            for (int i = 0; i < n; i++) {
                h.add(f.nextInt());
            }
            if (h.size() == 1) {
                System.out.println(2 * (h.iterator().next()));
            } else {
                int[] a = new int[h.size()];
                int count = 0;
                for (Integer i : h) {
                    a[count] = i;
                    count++;
                } 
                int max;
                int maxind;
                int smax;
                int smaxind;
                if (a[0] > a[1]) {
                    max = a[0];
                    maxind = 0;
                    smax = a[1];
                    smaxind = 1;
                } else {
                    max = a[1];
                    maxind = 1;
                    smax= a[0];
                    smaxind = 0;
                }
                for (int i = 2; i < a.length; i++) {
                    if (a[i] > max) {
                        smax = max;
                        smaxind = maxind;
                        max = a[i];
                        maxind = i;
                    } else if (a[i] > smax) {
                        smax = a[i];
                        smaxind = i;
                    }
                }
                int gcda = max;
                int gcdb = smax;
                for (int i = 0; i < a.length; i++) {
                    if (i != maxind && i != smaxind) {
                        gcda = gcd(gcda, a[i]);
                        gcdb = gcd(gcdb, a[i]);
                    }
                }
                if (gcdb + max > gcda + smax) {
                    System.out.println(max + gcdb);
                } else {
                    System.out.println(gcda + smax);
                }
            }
        }

    }

}
