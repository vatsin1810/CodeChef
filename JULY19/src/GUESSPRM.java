import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.StringTokenizer;

public class GUESSPRM {
    
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
    
    public static HashSet<Long> primeFactors (Long l) {
        HashSet<Long> factors = new HashSet<>();
        if (l == 0L) {
            return null;
        }
        boolean used = false;
        while (l % 2L == 0) {
            l = l >> 1;
            used = true;
        }
        if (used) {
            factors.add(2L);
        }
        for (long i = 3; i * i <= l; i += 2) {
            used = false;
            while (l % i == 0) {
                l /= i;
                used = true;;
            }
            if (used) {
                factors.add(i);
            }
        }
        if (l > 2) {
            factors.add(l);
        }
        return factors;
    }

    public static void main(String[] args) throws IOException {
        FastReader f = new FastReader();
        int t = f.nextInt();
        Random r = new Random();
        while (t-- > 0) {
            long x = r.nextInt(100) + 32000;
            System.out.println(("1 " + x));
            System.out.flush();
            long a = f.nextLong();
            if (a == -1L) {
                System.exit(0);
            }
            long x2 = x * x - a;
            HashSet<Long> factors = primeFactors(x2);
            if (factors.size() == 1) {
                System.out.println(("2 " + factors.iterator().next()));
                System.out.flush();
                if (f.next() == "No") {
                    System.exit(0);
                }
            } else {
                long s = x;
                long s2 = x * x;
                HashMap<Long, Long> rems = new HashMap<>();
                while (s > 0L) {
                    s2 = s2 - 2 * s + 1;
                    s--;
                    rems.clear();
                    boolean found = true;
                    for (Long i : factors) {
                        Long rem = s2 % i;
                        if (rems.containsKey(rem)) {
                            found = false;
                            break;
                        } else {
                            rems.put(rem, i);
                        }
                    }
                    if (found) {
                        break;
                    }
                }
                System.out.println(("1 " + s));
                System.out.flush();
                long b = f.nextLong();
                if (b == -1L) {
                    System.exit(0);
                }
                System.out.println(("2 " + rems.get(b)));
                System.out.flush();
                if (f.next() == "No") {
                    System.exit(0);
                }
            }
        }
//        for (int i = 0; i < 100; i++) {
//            System.out.println((i * i) % 23);
//        }
    }

}
