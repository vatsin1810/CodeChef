import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class EVEDG {
    private static boolean[] discovered;
    private static int[] CCs;
    private static ArrayList<Integer> CCedges;
    
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
    
    public static void bfs(ArrayList<Integer>[] adjList) {
        int CC = -1;
        for (int i = 0; i < adjList.length; i++) {
            if (!discovered[i]) {
                CC++;
                int CCTotal = 0;
                LinkedList<Integer> q = new LinkedList<>();
                discovered[i] = true;
                CCs[i] = CC;
                CCTotal += adjList[i].size();
                q.add(i);
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    for (Integer j : adjList[curr]) {
                        if (!discovered[j]) {
                            discovered[j] = true;
                            CCs[j] = CC;
                            CCTotal += adjList[j].size();
                            q.add(j);
                        }
                    }
                }
                CCedges.add(CCTotal / 2);
            }
        }
    }

    public static void main(String[] args) {
        FastReader f = new FastReader();
        int t = f.nextInt();
        while (t-- > 0) {
            int n = f.nextInt();
            int m = f.nextInt();
            if (m % 2 == 0) {
                for (int i = 0; i < m; i++) {
                    f.nextInt();
                    f.nextInt();
                }
                System.out.println(1);
                for (int i = 0; i < n; i++) {
                    System.out.print(1 + " ");
                }
                System.out.println();
            } else {
                ArrayList<Integer>[] adjList = new ArrayList[n];
                for (int i = 0; i < n; i++) {
                    adjList[i] = new ArrayList<Integer>();
                }
                for (int i = 0; i < m; i++) {
                    int u = f.nextInt() - 1;
                    int v = f.nextInt() - 1;
                    adjList[u].add(v);
                    adjList[v].add(u);
                }
                discovered = new boolean[n];
                CCs = new int[n];
                CCedges = new ArrayList<>();
                bfs(adjList);
                int size = CCedges.size();
                int CC = -1;
                boolean found = false;
                int[] subgraphs = new int[n];
                for (int i = 0; i < size; i++) {
                    if (CCedges.get(i) % 2 == 1) {
                        CC = i;
                        for (int j = 0; j < n; j++) {
                            if (CCs[j] == i && adjList[j].size() % 2 == 1) {
                                found = true;
                                subgraphs[j] = 2;
                                break;
                            }
                        }
                        if (found) {
                            break;
                        }
                    }
                }                
                if (!found) {
                    for (int i = 0; i < n; i++) {
                        if (CCs[i] == CC) {
                            subgraphs[i] = 2;
                            subgraphs[adjList[i].get(0)] = 3;
                            break;
                        }
                    }
                    System.out.println(3);
                    for (int i = 0; i < n; i++) {
                        if (subgraphs[i] == 0) {
                            System.out.print(1 + " ");
                        } else {
                            System.out.print(subgraphs[i] + " ");
                        }
                    }
                    System.out.println();
                } else {
                    System.out.println(2);
                    for (int i = 0; i < n; i++) {
                        if (subgraphs[i] == 0) {
                            System.out.print(1 + " ");
                        } else {
                            System.out.print(subgraphs[i] + " ");
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

}
