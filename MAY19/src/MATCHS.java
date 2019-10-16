import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class MATCHS {
    
    static HashMap<Pair, Boolean> dp = new HashMap<>();
    
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
    
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    static class Pair {
        long a;
        long b;
        Pair (long a, long b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (int) (a ^ (a >>> 32));
            result = prime * result + (int) (b ^ (b >>> 32));
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
    
    public static boolean isWinningPos(long n, long m) {
        LinkedList<Pair> moves = new LinkedList<>();
        if (m < n) {
            long temp = m;
            m = n;
            n = temp;
        }
        if (dp.containsKey(new Pair(n, m))) {
            return dp.get(new Pair(n, m));
        } else if (m % n == 0) {
            dp.put(new Pair(n, m), true);
            return true;
        }
        Pair or = new Pair(n, m);
        m -= n;
        while (m > 0) {
            if (m > n)
                moves.add(new Pair(n, m));
            else
                moves.add(new Pair(m, n));
            m -= n;
        }
        for (Pair p : moves) {
            if (p.b % p.a == 0) {
                dp.put(p, true);
            }
            if (dp.containsKey(p) && !dp.get(p)) {
                dp.put(or, true);
                return true;
            } else if (!dp.containsKey(p)) {
                boolean b = isWinningPos(p.a, p.b);
                dp.put(p, b);
                if (!b) {
                    dp.put(or, true);
                    return true;
                } 
            }
        }
        dp.put(or, false);
        return false;
        
        
    }

    public static void main(String[] args) {
        FastReader f = new FastReader();
        int t = f.nextInt();
        //Random r = new Random();
        while (t-- > 0) {
            long n = f.nextLong();
            long m = f.nextLong();
            //boolean b = isWinningPos(n, m);
            boolean turn = true;
            while (true) {
                if (m < n) {
                    long temp = m;
                    m = n;
                    n = temp;
                }
                if (m / n > 1 || m == n) {
                    break;
                } else {
                    m -= n;
                    turn = !turn;
                }
            }
            if (turn) {
                System.out.println("Ari");
            } else {
                System.out.println("Rich");
            }
        }

    }

}
