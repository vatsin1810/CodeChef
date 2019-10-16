import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BINARY {
    
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
    
    static class BoolBit implements Comparable<BoolBit> {
        boolean bit;
        int key;
        
        BoolBit(boolean bit, int key){
            this.bit = bit;
            this.key = key;
        }

        @Override
        public int compareTo(BoolBit o) {
            if (o.key != this.key)
                return this.key - o.key;
            else if (this.bit != o.bit) {
                if (this.bit) {
                    return -1;
                } else {
                    return 1;
                }
            } else
                return 0;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (bit ? 1231 : 1237);
            result = prime * result + key;
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
            BoolBit other = (BoolBit) obj;
            if (bit != other.bit)
                return false;
            if (key != other.key)
                return false;
            return true;
        }
        
    }

    public static void main(String[] args) {
        FastReader f = new FastReader();
        int t = f.nextInt();
        while (t-- > 0) {
            int n = f.nextInt();
            int z = f.nextInt();
            boolean[] a = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (f.nextInt() == 1) {
                    a[i] = true;
                }
            }
            for (int i = 0; i < z; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (!a[j] && a[j + 1]) {
                        a[j] = true;
                        a[j + 1] = false;
                        j++;
                    }
                }
            }
            String s = "";
            for (boolean b : a) {
                if (b) {
                    s = s + "1 ";
                } else {
                    s = s + "0 ";
                }   
            }
            System.out.println(s);
//            int count = 0;
//            int num01 = 0;
//            PriorityQueue<BoolBit> pQ = new PriorityQueue<>();
//            while (count < z && count < n) {
//                if (count > 1 && a[count - 1] && !a[count - 2]) {
//                    num01++;
//                }
//                if (num01 > 0 && a[count] && a[count - 1])
//                    pQ.add(new BoolBit(a[count], a[count] ? count - z - num01 + 1 : count));
//                else
//                    pQ.add(new BoolBit(a[count], a[count] ? count - z - num01 : count));
//                count++;
//            }
//            if (z < n) {
//                if (z == 1) {
//                    while (count < n) {
//                        pQ.add(new BoolBit(a[count], a[count] ? count - z : count));
//                        count++;
//                    }
//                } else {
//                    while (count < n) {
//                        if (a[count - 1] && !a[count - 2]) {
//                            num01++;
//                        }
//                        if (num01 > 0 && a[count] && a[count - 1])
//                            pQ.add(new BoolBit(a[count], a[count] ? count - z - num01 + 1 : count));
//                        else
//                            pQ.add(new BoolBit(a[count], a[count] ? count - z - num01 : count));
//                        if (a[count - z] && count > z && !a[count - z - 1]) {
//                            num01--;
//                        }
//                        count++;
//                    }
//                }
//            }
//            String s = "";
//            while (!pQ.isEmpty()) {
//                BoolBit b = pQ.poll();
//                if (b.bit) {
//                    s = s + "1 ";
//                } else {
//                    s = s + "0 ";
//                }
//            }
//            System.out.println(s);
        }

    }

}
