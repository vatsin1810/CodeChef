import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CCC {
    
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
    
    static class comp implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
        
    }

    public static void main(String[] args) {
        FastReader f = new FastReader();
        int t = f.nextInt();
        while (t-- > 0) {
            int n = f.nextInt();
            int z = f.nextInt();
            ArrayList<Integer> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                a.add(f.nextInt());
            }
            Collections.sort(a);
            int min = Integer.MAX_VALUE;
            for (int i = z - 1; i < n; i++) {
                int total = 0;
                total += (n - i) * a.get(i);
                for (int j = i - z + 1; j < i; j++) {
                    total += a.get(i);
                }
                if (total < min) {
                    min = total;
                }
            }
            System.out.println(min);
//            PriorityQueue<Integer> pq = new PriorityQueue<>(new comp());
//            for (int i = 0; i < z; i++) {
//                pq.add(f.nextInt());
//            }
//            for (int i = z; i < n; i++) {
//                int x = f.nextInt();
//                if (x < pq.peek()) {
//                    pq.poll();
//                    pq.add(x);
//                }
//            }
//            int max = pq.peek();
//            int total = 0;
//            while (!pq.isEmpty()) {
//                total += pq.poll();
//            }
//            total += max * (n - z);
//            System.out.println(total);
        }

    }

}
