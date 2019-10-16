import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class WTBTR {
    
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
//        Random r = new Random();
        while (t-- > 0) {
            int n = f.nextInt();
            int[][] arr = new int[n][2];
            double mind = Double.MAX_VALUE;
            long[] ps1 = new long[n];
            long[] ps2 = new long[n];
            for (int i = 0; i < n; i++) {
                int x = f.nextInt();
                int y = f.nextInt();
                ps1[i] = x + y;
                ps2[i] = y - x;
            }
            Arrays.sort(ps1);
            Arrays.sort(ps2);
            for (int i = 0; i < n - 1; i++) {
                double d1 = Math.abs(ps1[i] - (ps1[i] + ps1[i + 1]) / 2.0);
                double d2 = Math.abs(ps2[i] - (ps2[i] + ps2[i + 1]) / 2.0);
                if (d1 < mind) {
                    mind = d1;
                } 
                if (d2 < mind) {
                    mind = d2;
                }
            }
//            for (int i = 0; i < n; i++) {
//                arr[i][0] = f.nextInt();
//                arr[i][1] = f.nextInt();
//            }
//            double mind = Integer.MAX_VALUE;
//            for (int i = 0; i < n; i++) {
//                for (int j = i + 1; j < n; j++) {
//                    double d1 = Math.abs(arr[i][0] + arr[i][1] - (arr[i][0] + arr[i][1] 
//                            + arr[j][0] + arr[j][1]) / 2.0);
//                    double d2 = Math.abs(arr[i][1] - arr[i][0] - ( - arr[i][0] + arr[i][1] 
//                            - arr[j][0] + arr[j][1]) / 2.0);
//                    if (d1 < mind) {
//                        mind = d1;
//                    } 
//                    if (d2 < mind) {
//                        mind = d2;
//                    }
//                }
//            }
            System.out.println(mind);
        }

    }

}
