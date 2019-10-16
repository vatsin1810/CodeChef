import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class FENCE {
    
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
    
    static class Pair {
        int a;
        int b;
        
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + a;
            result = prime * result + b;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Pair other = (Pair) obj;
            if (a != other.a)
                return false;
            if (b != other.b)
                return false;
            return true;
        }
    }
    

    public static void main(String[] args) {
        FastReader f = new FastReader();
        int t = f.nextInt();
        for (int i = 0; i < t; i++) {
            int n = f.nextInt();
            int m = f.nextInt();
            int k = f.nextInt();
            HashSet<Pair> h = new HashSet<>();
            long total = 0;
            for (int j = 0; j < k; j++) {
                int r = f.nextInt();
                int c = f.nextInt();
                h.add(new Pair(r, c));
            }
            for (Pair p : h) {
                int a = p.a;
                int b = p.b;
                if (a == 1 || !h.contains(new Pair(a - 1, b))) {
                    total++;
                }
                if (b == 1 || !h.contains(new Pair(a, b - 1))) {
                    total++;
                }
                if (a == n || !h.contains(new Pair(a + 1, b))) {
                    total++;
                }
                if (b == m || !h.contains(new Pair(a, b + 1))) {
                    total++;
                }
            }
            System.out.println(total);
        }

    }

}
