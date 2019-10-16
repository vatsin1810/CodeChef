import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P7 {
    
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
        HashMap<Character, LinkedList<Integer>> m = new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            m.put(Character.forDigit(i, 10), new LinkedList<Integer>());
        }
        int n = f.nextInt();
        for (int i = 1; i <= n; i++) {
            String temp = f.nextLine();
            int length = temp.length();
            for (int j = 0; j < length; j++) {
                Character c = temp.charAt(j);
                m.get(c).add(i);
            }
            
        }
        for (int i = 0; i <= 9; i++) {
            LinkedList<Integer> l = m.get(Character.forDigit(i, 10));
            for (Integer a : l) {
                System.out.print(a + " ");
            }
        }
    }
}
