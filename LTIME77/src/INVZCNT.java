import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class INVZCNT {
    
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
    
    public static long countInv(int low, int high, int[] a) {
        if (low == high) {
            return 0;
        }
        long left = countInv(low, (low + high) / 2, a);
        long right = countInv((low + high) / 2 + 1, high, a);
        long totalInv =  left + right;
        int countleft = 0;
        int countright = 0;
        int leftsize = (low + high) / 2 - low + 1;
        int rightsize = high - (low + high) / 2;
        int[] leftarr = new int[(low + high) / 2 - low + 1];
        int[] rightarr = new int[high - (low + high) / 2];
        for (int i = low; i <= (low + high) / 2; i++) {
            leftarr[countleft] = a[i];
            countleft++;
        }
        for (int i = (low + high) / 2 + 1; i <= high; i++) {
            rightarr[countright] = a[i];
            countright++;
        }
        countleft = 0;
        countright = 0;
        for (int i = low; i <= high; i++) {
            if (leftarr[countleft] <= rightarr[countright]) {
                a[i] = leftarr[countleft];
                countleft++;
            } else {
                a[i] = rightarr[countright];
                countright++;
                totalInv += (long) leftsize - countleft;
            }
            if (countleft == leftsize) {
                while (i < high) {
                    i++;
                    a[i] = rightarr[countright];
                    countright++;
                }
            } else if (countright == rightsize) {
                while (i < high) {
                    i++;
                    a[i] = leftarr[countleft];
                    countleft++;
                }
            }
        }
        return totalInv;
    }

    public static void main(String[] args) {
        FastReader f = new FastReader();
        int t = f.nextInt();
        while (t -- > 0) {
            int n = f.nextInt();
            int q = f.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = f.nextInt();
            }
            for (int i = 0; i < q; i++) {
                int k = f.nextInt();
                int[] b = new int[n];
                for (int j = 0; j < n; j++) {
                    b[j] = a[j] ^ k;
                }
                System.out.println(countInv(0, n - 1, b));
            }
        }

    }

}
