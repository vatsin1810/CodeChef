import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.StringTokenizer;

public class ADAROKS2 {
    
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
    
    static class Point {
        int x;
        int y;
        
        Point (int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
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
            Point other = (Point) obj;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }
    }

    public static void main(String[] args) {
        FastReader f = new FastReader();
        int t = f.nextInt();
        Random r = new Random();
        while (t-- > 0) {
            int n = f.nextInt();
            boolean[][] points = new boolean[n][n];
            int size = 0;
            while(size < 2 * n) {
                int x = r.nextInt(n);
                int y = r.nextInt(n);
                if (!points[x][y]) {
                    points[x][y] = true;
                    size++;
                }
            }
            long count = System.currentTimeMillis();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int a = i;
                    int b = j;
                    if (points[a][b]) {
                        while (true) {
                            LinkedList<Point> column = new LinkedList<>();
                            LinkedList<Point> row = new LinkedList<>();
                            for (int k = 0; k < n; k++) {
                                if (points[a][k] && k != b) {
                                    row.add(new Point(a, k));
                                }
                                if (points[k][b] && k != a) {
                                    column.add(new Point(k, b));
                                }
                            }
                            boolean br = false;
                            for (Point p1 : column) {
                                for (Point p2 : row) {
                                    if (points[p1.x][p2.y]) {
                                        a = r.nextInt(n);
                                        b = r.nextInt(n);
                                        br = true;
                                        break;
                                    }
                                }
                                if (br) {
                                    break;
                                }
                            }
                            if (!br) {
                                break;
                            }
                        }
                    }
//                    if (points[i][j]) {
//                        int x = j;
//                        int y = i;
//                        for (int k = 0; k < n; k++) {
//                            for (int l = 0; l < n; l++) {
//                                while (k != y && l != x && points[k][x] && points[y][l] && points[k][l]) {
//                                    points[y][x] = false;
//                                    x = r.nextInt(n);
//                                    y = r.nextInt(n);
//                                    points[y][x] = true;
//                                    k = 0;
//                                    l = 0;
//                                }
//                            }
//                        }
//                    }
                }
            }
            String s = "";
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (points[i][j]) {
                        s = s + "O";
                    } else {
                        s = s + ".";
                    }
                }
                s = s + "\n";
            }
            System.out.println(s);
            System.out.println(System.currentTimeMillis() - count);
        }

    }

}
