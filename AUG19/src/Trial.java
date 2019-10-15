import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Random;
import java.util.StringTokenizer;

public class Trial {
    
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
    
    public static long countLast(long lr1, long lr2, int i1, int i2) {
        long total = 0;
        long maxl = 1000000007L;
        for (int j = 1; j <= 9; j++) {
            if (j < i1) {
                if (j < i2) {
                    total = (total + (((i1 * j * lr1) % maxl) * lr1) % maxl) % maxl;
                } else if (j == i2) {
                    total = (total + (((((((i1 - 1) * lr1) % maxl + lr2) % maxl) * lr1) % maxl) * j) 
                            % maxl) % maxl;
                } else {
                    total = (total + ((((i1 - 1) * j * lr1) % maxl) * lr1) % maxl) % maxl;
                }
            } else if (j == i1) {
                total = (total + (((i1 * j * lr1) % maxl) * lr1) % maxl) % maxl;
//                if (j < i2) {
//                    total = (total + (((i1 * j * lr1) % maxl) * lr1) % maxl) % maxl;
//                } else if (j == i2) {
//                    total = (total + ((((i1 * j * lr1) % maxl) * lr1) % maxl) % maxl) 
//                            % maxl;
//                } else {
                    
            } else {
                if (j < i2) {
                    total = (total + ((((i1 + 1) * j * lr1) % maxl) * lr1) % maxl) % maxl;
                } else if (j == i2) {
                    total = (total + ((((((i1 * lr1) % maxl + lr2) % maxl) * lr1) % maxl) * j) 
                            % maxl) % maxl;
                } else {
                    total = (total + ((((i1 * j * lr1) % maxl) * lr1) % maxl) % maxl) 
                            % maxl;
                }
            }
        }
        return total % maxl;
    }
    
    public static long f(StringBuilder s, int size) {
        long total = 0;
        BigInteger max = new BigInteger("1000000007");
        long maxl = 1000000007L;
        int c = Character.digit(s.charAt(0), 10);
        int pos = 0;
        for (int i = 1; i < size; i++) {
            if (c != Character.digit(s.charAt(i), 10)) {
                BigInteger b = BigInteger.TEN.pow(size - pos - 1);
                long bl = b.mod(max).longValue();
                total = (total + ((bl * c) % maxl)) % maxl;
                pos = i;
                c = Character.digit(s.charAt(i), 10);
            }
        }
        BigInteger b = BigInteger.TEN.pow(size - pos - 1);
        long bl = b.mod(max).longValue();
        total = (total + ((bl * c) % maxl)) % maxl;
        return total;
    }
    
    public static long countStr(StringBuilder s, int size) {
        BigInteger bl = BigInteger.ZERO;
        BigInteger br = new BigInteger(s.toString());
        BigInteger bten = BigInteger.TEN.pow(size - 1);
        long ll, lr, lten;
        BigInteger max = new BigInteger("1000000007");
        long maxl = 1000000007L;
        long total = 0;
        char c1, c2;
        c2 = s.charAt(0);
        if (size == 1) {
            br = BigInteger.ONE;
        } else {
            br = br.mod(bten);
            br = br.add(BigInteger.ONE);
        }
        lr = br.mod(max).longValue();
        lten = bten.mod(max).longValue();
        for (int i = 1; i <= 9; i++) {
            if (i < Character.digit(c2, 10)) {
                total = (total + (((lten * lten) % maxl) * i) % maxl) % maxl;
            } else if (i == Character.digit(c2, 10)) {
                total = (total + (((lr * lten) % maxl) * i) % maxl) % maxl;
            }
        }
        bten = bten.divide(BigInteger.TEN);
        if (size == 1) {
            return total;
        }
        c1 = c2;
        c2 = s.charAt(1);
        if (size == 2) {
            br = BigInteger.ONE;
        } else {
            br = br.mod(bten);
            if (br.equals(BigInteger.ZERO)) {
                br = bten;
            }
        }
        lr = br.mod(max).longValue();
        lten = bten.mod(max).longValue();
        total = (total + countLast(lten, lr, Character.digit(c1, 10), Character.digit(c2, 10))) 
                % maxl;
        for (int i = 2; i < size; i++) {
            bl = bl.multiply(BigInteger.TEN);
            bl = bl.add(BigInteger.valueOf(Character.digit(c1, 10)));
            c1 = c2;
            c2 = s.charAt(i);
            bten = bten.divide(BigInteger.TEN);
            if (i == size - 1) {
                br = BigInteger.ONE;
            } else {
                br = br.mod(bten);
                if (br.equals(BigInteger.ZERO)) {
                    br = bten;
                }
            }
            ll = (9L * bl.mod(max).longValue()) % maxl; 
            lr = br.mod(max).longValue();
            lten = bten.mod(max).longValue();
            int i1 = Character.digit(c1, 10);
            int i2 = Character.digit(c2, 10);
            total = (total + 45L * ((((ll * lten) % maxl) * lten) % maxl)) % maxl;
            total = (total + countLast(lten, lr, i1, i2)) % maxl;
        }
        return total % maxl;
    }
    public static void main(String[] args) {
//        FastReader f = new FastReader();
//        int t = f.nextInt();
//        while (t-- > 0) {
//            int nl = f.nextInt();
//            BigInteger b = new BigInteger(f.next());
//            int nr = f.nextInt();
//            StringBuilder r = new StringBuilder(f.next());
//            b = b.subtract(BigInteger.ONE);
//            String l = b.toString();
//            long resl = countStr(new StringBuilder(l), l.length());
//            long resr = countStr(r, nr);
//            int res = (int) (resr - resl);
//            if (res < 0) {
//                System.out.println(res + 1000000007);
//            } else {
//                System.out.println(res);
//            }
//        }
//        Random r = new Random();
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < 100000; i++) {
            s.append("3");
        }
        long time = System.currentTimeMillis();
        countStr(s, 100000);
        System.out.println(System.currentTimeMillis() - time);
//        long total = 0;
//        for (int i = 1; i < 10000; i++) {
//            StringBuilder a = new StringBuilder(String.valueOf(i));
//            long l = countStr(a, a.length());
//            total = (total + f(a, a.length())) % 1000000007L;
//            if (l != total) {
//                System.out.println(i);
//            }
//        }
//        StringBuilder ne = new StringBuilder("1");
//        for (int j = 0; j < 1000000; j++) {
//            ne.append("0");
//        }
//        BigInteger br1 = new BigInteger(ne.toString());
//        BigInteger b = BigInteger.TEN.pow(1000000);
        //System.out.println(countStr(new StringBuilder(String.valueOf(100600)), 6));
    }

}
