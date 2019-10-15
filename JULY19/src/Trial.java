import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
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
    
    static class intString {
        int i;
        String s;
        
        intString(int i, String s) {
            this.i = i;
            this.s = s;
        }
    }
    
    public static intString findMin(ArrayList<Integer> a, String s, int penalty) {
        intString min = new intString(Integer.MAX_VALUE, "");
        if (a.size() == 1) {
            return new intString(penalty, s);
        }
        for (int i = 0; i < a.size(); i++) {
            ArrayList<Integer> a2 = new ArrayList<>();
            for (Integer j : a) {
                a2.add(j);
            }
            int x = 0;
            if (i == a2.size() - 1) {
                x = a2.get(i) + a2.get(0);
                a2.set((int) i, x);
                a2.remove((int) 0);
            } else {
                x = a2.get(i) + a2.get(i + 1);
                a2.set((int) i, x);
                a2.remove((int) i + 1);
            }
            intString r = findMin(a2, s + i, penalty + x);
            if (r.i < min.i) {
                min.i = r.i;
                min.s = r.s;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        FastReader f = new FastReader();
        int t = f.nextInt();
        while (t-- > 0) {
            int n = f.nextInt();
            ArrayList<Integer> a = new ArrayList<>();
            for (int i = 1; i <= n - 1; i++) {
                a.add(i);
            }
//            int min = Integer.MAX_VALUE;
//            int minp = 0;
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> a2 = new ArrayList<>();
                for (Integer j : a) {
                    a2.add(j);
                }
                a2.add(i, 0);
                int counter = 0;
                System.out.println(i + 1);
                while (a2.size() > 2) {
                    int size = a2.size();
                    int next = (counter + 1) % size;
                    if (!(a2.get(counter) < 1) && a2.get(next) < 1) {
                        a2.set(next, a2.get(next) - a2.get(counter));
                        System.out.print(a2.get(counter) + " ");
                    } else if (!(a2.get(counter) < 1)) {
                        a2.remove((int) next);
                    }
                    if (counter >= a2.size()) {
                        counter = 0;
                    } else {
                        counter = (counter + 1) % a2.size();
                    }
                }
                System.out.println();
                System.out.println();
//                int r = fi - Math.min(a2.get(0), a2.get(1));
//                if (r < min && Math.max(a2.get(0), a2.get(1)) <= fi) {
//                    min = r;
//                    minp = i + 1;
//                }
            }
//            if (min == Integer.MAX_VALUE) {
//                System.out.println("impossible");
//            } else {
//                System.out.println("possible");
//                System.out.println(minp + " " + min);
//            }
            
        }
    }

}
