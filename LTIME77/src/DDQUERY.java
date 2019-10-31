import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DDQUERY {
    private static boolean[] discovered;
    private static int[] layers;
    private static int[][] dist;
    
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
    
    public static void bfs(int u, LinkedList<Integer>[] adjList) {
        dist[u][u] = 0;
        discovered[u] = true;
        LinkedList<Integer> q = new LinkedList<>();
        q.add(u);
        while (!q.isEmpty()) {
            int v = q.poll();
            LinkedList<Integer> neighbours = adjList[v];
            for (Integer j : neighbours) {
                if (!discovered[j]) {
                    discovered[j] = true;
                    dist[u][j] = dist[u][v] + 1;
                    q.add(j);
                }
            }
        }
    }

    public static void main(String[] args) {
        FastReader f = new FastReader();
        int t = f.nextInt();
        while (t-- > 0) {
            int n = f.nextInt();
            int q = f.nextInt();
            LinkedList<Integer>[] adjList = new LinkedList[n];
            discovered = new boolean[n];
            layers = new int[n];
            dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                adjList[i] = new LinkedList<Integer>();
            }
            for (int i = 0; i < n - 1; i++) {
                int u = f.nextInt() - 1;
                int v = f.nextInt() - 1;
                adjList[u].add(v);
                adjList[v].add(u);
            }
            for (int i = 0; i < n; i++) {
                Arrays.fill(discovered, false);
                bfs(i, adjList);
            }
            for (int i = 0; i < q; i++) {
                int a = f.nextInt() - 1;
                int da = f.nextInt();
                int b = f.nextInt() - 1;
                int db = f.nextInt();
                boolean found = false;
                for (int j = 0; j < n; j++) {
                    if (dist[j][a] == da && dist[j][b] == db) {
                        System.out.println(j + 1);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println(-1);
                }
            }
        }

    }

}
