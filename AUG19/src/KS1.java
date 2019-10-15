import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class KS1 {
    
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
            HashMap<Integer, ArrayList<Integer>> prefix = new HashMap<>();
            int[] prefixxor = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = f.nextInt();
            }
            prefixxor[0] = a[0];
            ArrayList<Integer> l0 = new ArrayList<>();
            ArrayList<Integer> l1 = new ArrayList<>();
            long total = 0;
            if (prefixxor[0] == 0) {
                l0.add(-1);
                l0.add(0);
                prefix.put(0, l0);
            } else {
                l0.add(0);
                l1.add(-1);
                prefix.put(prefixxor[0], l0);
                prefix.put(0, l1);
            }
            for (int i = 1; i < n; i++) {
                prefixxor[i] = prefixxor[i - 1] ^ a[i];
                if (prefix.containsKey(prefixxor[i])) {
                    prefix.get(prefixxor[i]).add(i);
                } else {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(i);
                    prefix.put(prefixxor[i], l);
                }
            }
            Set<Integer> keyset = prefix.keySet();
            for (Integer i : keyset) {
                ArrayList<Integer> l = prefix.get(i);
                int size = l.size();
                int count = - size + 1;
                for (int j = 0; j < size; j++) {
                    total += ((long) l.get(j)) * ((long) count);
                    count += 2;
                }
                total -= (((long) size) * ((long) (size - 1))) / 2L;
            }
            System.out.println(total);
        }
    }
}
