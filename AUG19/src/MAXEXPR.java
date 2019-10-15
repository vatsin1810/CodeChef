import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MAXEXPR {
    
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
            double[] k = new double[n];
            double[] c = new double[n];
            double[] x = new double[n];
            for (int i = 0; i < n; i++) {
                k[i] = f.nextDouble();
            }
            for (int i = 0; i < n; i++) {
                c[i] = f.nextDouble();
            }
            double kc = 0.0;
            double div = 0.0;
            for (int i = 0; i < n; i++) {
                kc += k[i] * c[i];
                div += 1.0 / (4.0 * k[i]);
            }
            double lambda = kc / div;
            for (int i = 0; i < n; i++) {
                x[i] = (1.0 / (4.0 * k[i] * k[i])) * lambda - c[i];
            }
            double fs = 0;
            boolean possible = true;
            for (int i = 0; i < n; i++) {
                if (x[i] + c[i] >= 0) {
                    fs += Math.sqrt(x[i] + c[i]);
                } else {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                System.out.print(fs + " ");
                for (int i = 0; i < n; i++) {
                    System.out.print(x[i] + " ");
                }
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }

    }

}
