import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.StringTokenizer;

public class CIRMERGE {
    
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
        Random r = new Random();
        
        //FastReader f = new FastReader();
        int t = 100;
        while (t-- > 0) {
        int n = 7;
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> a2 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int rand = r.nextInt(50) + 1;
                a.add(rand);
                a2.add(rand);
            }
            intString x = findMin(a, "", 0);
            ArrayList<Integer> l = new ArrayList<>();
            for (int i = 0; i < n - 1; i++) {
                l.add(a.get(i) + a.get(i + 1));
            }
            l.add(a.get(n - 1) + a.get(0));
            int total = 0;
            while (l.size() > 1) {
                int min = Integer.MAX_VALUE;
                int minind = 0;
                int size = l.size();
                for (int i = 0; i < size; i++) {
                    if (l.get(i) < min) {
                        min = l.get(i);
                        minind = i;
                    }
                }
                total += min;
                a.set(minind, min);
                a.remove((int) (minind == size - 1 ? 0 : minind + 1));
                size = a.size();
                l.clear();
                for (int i = 0; i < size - 1; i++) {
                    l.add(a.get(i) + a.get(i + 1));
                }
                l.add(a.get(size - 1) + a.get(0));
            }
            if (true) {
                for (Integer i : a2) {
                    System.out.print(i + " ");
                }
                System.out.println();
                System.out.println(x.s);
                System.out.println(x.i);
                System.out.println(total);
            }
        }
    }

}


