import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.StringTokenizer;

public class INTRPATH {
    static boolean[] discovered;
    static int[] parent;
    static HashSet<Integer>[] children;
    static int[] size;
    
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
    
    public static int size(int root) {
        HashSet<Integer> ch = children[root];
        int total = 1;
        for (Integer i : ch) {
            total += size(i);
        }
        size[root] = total;
        return total;
    }
    
    public static ArrayList<Integer> path(int u, int v) {
        LinkedList<Integer> path1 = new LinkedList<>();
        LinkedList<Integer> path2 = new LinkedList<>();
        int r1 = u;
        int r2 = v;
        path1.add(r1);
        path2.add(r2);
        while (parent[r1] != r1) {
            r1 = parent[r1];
            path1.addFirst(r1);
        }
        while (parent[r2] != r2) {
            r2 = parent[r2];
            path2.addFirst(r2);
        }
        Iterator<Integer> it1 = path1.iterator();
        Iterator<Integer> it2 = path2.iterator();
        r1 = path1.peek();
        r2 = path2.peek();
        int lcv = 0;
        while (it1.hasNext() && it2.hasNext()) {
            r1 = it1.next();
            r2 = it2.next();
            if (r1 != r2) {
                break;
            } 
            lcv = r1;
        }
        ArrayList<Integer> path = new ArrayList<>();
        it1 = path1.descendingIterator(); 
        it2 = path2.iterator();
        while (it1.hasNext()) {
            int i = it1.next();
            if (i != lcv) {
                path.add(i);
            } else {
                path.add(lcv);
                break;
            }
        }
        while (it2.hasNext()) {
            int i = it2.next();
            if (i == lcv) {
                break;
            }
        }
        while (it2.hasNext()) {
            int i = it2.next();
            path.add(i);
        }
        return path;
    }
    
    public static long countIPaths(ArrayList<Integer> path) {
        HashSet<Integer> h = new HashSet<Integer>();
        Iterator<Integer> it = path.iterator();
        while (it.hasNext()) {
            h.add(it.next());
        }
        long total = 0;
        for (int i = 0; i < path.size(); i++) {
            int u = path.get(i);
            ArrayList<Integer> ne = new ArrayList<>();
            for (Integer j : children[u]) {
                if (!h.contains(j)) {
                    ne.add(size[j]);
                }
            }
            if (!h.contains(parent[u])) {
                ne.add(size.length - size[u]);
            }
            total += 1L;
            for (int j = 0; j < ne.size(); j++) {
                total += (long) ne.get(j);
                for (int k = j + 1; k < ne.size(); k++) {
                    total += (long) (ne.get(j) * ne.get(k));
                }
            }
        }
        return total;
    }
    
    public static void dfsTree(LinkedList<Integer>[] adjList, int root) {
        discovered = new boolean[adjList.length];
        parent = new int[adjList.length];
        size = new int[adjList.length];
        children = new HashSet[adjList.length];
        for (int i = 0; i < children.length; i++) {
            children[i] = new HashSet<>();
        }
        LinkedList<Integer> queue = new LinkedList<>();
        parent[root] = root;
        discovered[root] = true;
        queue.add(root);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            LinkedList<Integer> n = adjList[u];
            for (Integer v : n) {
                if (!discovered[v]) {
                    discovered[v] = true;
                    parent[v] = u;
                    children[u].add(v);
                    queue.add(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        FastReader f = new FastReader();
        int t = f.nextInt();
        Random r = new Random();
        while (t-- > 0) {
            int n = f.nextInt();
            int q = f.nextInt();
            LinkedList<Integer>[] adjList = new LinkedList[n];
            for (int i = 0; i < adjList.length; i++) {
                adjList[i] = new LinkedList<>();
            }
            for (int i = 0; i < n - 1; i++) {
                int u = f.nextInt() - 1;
                int v = f.nextInt() - 1;
                adjList[u].add(v);
                adjList[v].add(u);
            }
            int root = r.nextInt(n); 
            dfsTree(adjList, root);
            size(root);
            while (q-- > 0) {
                int u = f.nextInt() - 1;
                int v = f.nextInt() - 1;
                ArrayList<Integer> path = path(u, v);
                System.out.println(countIPaths(path));
            }
        }

    }

}
