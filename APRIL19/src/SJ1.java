import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class SJ1 {
    static boolean[] discovered;
    static int[] parent;
    static LinkedList<Integer>[] adjList;
    static LinkedList<Integer> leaves;
    static long[] vs;
    static long[] ms;
    static long[] as;
    
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
    
    public static void bfs(int vertex) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(vertex);
        as[vertex] = vs[vertex];
        while(!queue.isEmpty()) {
            int i = queue.pollFirst();
            discovered[i] = true;
            LinkedList<Integer> n = adjList[i];
            for (Integer j : n) {
                if(!discovered[j]) {
                    parent[j] = i;
                    queue.add(j);
                    as[j] = gcd(vs[j], as[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        FastReader f = new FastReader();
        long time1 = 0;
        long time2 = 0;
        int t = f.nextInt();
        for (int z = 0; z < t; z++) {
            int n = f.nextInt();
            discovered = new boolean[n];
            parent = new int[n];
            adjList = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                adjList[i] = new LinkedList<>();
            }
            leaves = new LinkedList<>();
            vs = new long[n];
            ms = new long[n];
            
            for (int i = 0; i < n - 1; i++) {
                int u = f.nextInt() - 1;
                int v = f.nextInt() - 1;
                adjList[u].add(v);
                adjList[v].add(u);
            }
            for (int i = 0; i < n; i++) {
                vs[i] = f.nextLong();
            }
            for (int i = 0; i < n; i++) {
                ms[i] = f.nextLong();
            }
            for (int i = 1; i < n; i++) {
                LinkedList<Integer> l = adjList[i];
                if (l.size() == 1) {
                    leaves.add(i);
                }
            }
            as = new long[n];
            long time = System.currentTimeMillis();
            bfs(0);
            time1 += System.currentTimeMillis() - time;
            time = System.currentTimeMillis();
            if (leaves.size() == 0) {
                leaves.add(0);
            }
            for (Integer i : leaves) {
                long m = ms[i];
                long a = as[i];
                long d = m % a;
                if (d == 0) {
                    System.out.println(Math.max(m - a, 0) + " ");
                } else if (d == m) {
                    long j = a % m;
                    if (j == 0) {
                        System.out.println(0 + " ");
                    } else {
                        d = m % j;
                        if (d == 0) {
                            System.out.println(Math.max(m - j, 0) + " ");
                        } else {
                            System.out.println((m / j) * j + " ");
                        }
                    }
                } else {
                    System.out.println((m / a) * a + " ");
                }
            }
            time2 += System.currentTimeMillis() - time;
        }
        System.out.println(time1);
        System.out.println(time2);

    }

}
