import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SUBREM {
    static boolean[] discovered;
    static int[] parent;
    static HashSet<Integer>[] adjList;
    static int[] sums;
    static int[] weights;
    
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
    
    
    public static int sumWeights(int vertex) {
        HashSet<Integer> l = adjList[vertex];
        discovered[vertex] = true;
        int total = weights[vertex];
        for (Integer i : l) {
            if (!discovered[i]) {
                total += sumWeights(i);
                parent[i] = vertex;
            }
        }
        sums[vertex] = total;
        return total;
    }
    
    public static void delSubTree(int vertex) {
        HashSet<Integer> h = adjList[vertex];
        for (Integer i : h) {
            if (!discovered[i] && i != parent[vertex]) {
                discovered[i] = true;
                sums[i] = Integer.MAX_VALUE;
                delSubTree(i);
            }
        }
        
    }
    
    public static void delete(int vertex) {
        if (vertex == 0) {
            Arrays.fill(sums, Integer.MAX_VALUE);
            sums[0] = 0;
            return;
        }
        adjList[parent[vertex]].remove(vertex);
        adjList[vertex].remove(parent[vertex]);
        int p = vertex;
        int s = sums[vertex];
        while (p != 0) {
            sums[parent[p]] = sums[parent[p]] - s;
            p = parent[p];
        }
        Arrays.fill(discovered, false);
        sums[vertex] = Integer.MAX_VALUE;
        delSubTree(vertex);
    }
    
    public static int findMin() {
        int minind = 0;
        int min = Integer.MAX_VALUE;
        int size = sums.length;
        for (int i = 0; i < size; i++) {
            if (min > sums[i]) {
                minind = i;
                min = sums[i];
            }
        }
        return minind;
    }
    

    public static void main(String[] args) {
        FastReader f = new FastReader();
        int t = f.nextInt();
        for (int z = 0; z < t; z++) {
            int n = f.nextInt();
            int x = f.nextInt();
            int k = 0;
            sums = new int[n];
            discovered = new boolean[n];
            adjList = new HashSet[n];
            weights = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                adjList[i] = new HashSet<Integer>();
            }
            
            for (int i = 0; i < n; i++) {
                int j = f.nextInt();
                weights[i] = j;
            }
            for (int i = 0; i < n - 1; i++) {
                int u = f.nextInt() - 1;
                int v = f.nextInt() - 1;
                adjList[u].add(v);
                adjList[v].add(u);
            }
            sumWeights(0);
            int min = findMin();
            while(sums[min] < - x) {
                delete(min);
                k++;
                min = findMin();
            }
            System.out.println(sums[0] - x * k);
        }
                

    }

}
