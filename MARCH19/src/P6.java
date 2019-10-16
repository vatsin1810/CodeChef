import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;

public class P6 {
    
    private static Random generator = new Random();
    private static HashSet<Game> dict;
    
    static class Game {
        int start;
        int size;
        StringBuilder adjString;
        
        Game(int start, StringBuilder adjString) {
            this.start = start;
            this.size = adjString.length();
            this.adjString = adjString;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((adjString == null) ? 0 : adjString.hashCode());
            result = prime * result + size;
            result = prime * result + start;
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
            Game other = (Game) obj;
            if (size != other.size)
                return false;
            if (start != other.start)
                return false;
            if (adjString == null) {
                if (other.adjString != null)
                    return false;
            } else if (!adjString.equals(other.adjString))
                return false;
            return true;
        }
    }
    
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
    
    public static HashMap<Integer, Boolean> cloneMap(HashMap<Integer, Boolean> m) {
        Set<Integer> s = m.keySet();
        HashMap<Integer, Boolean> clone = new HashMap<>();
        for (Integer i : s) {
            clone.put(i, m.get(i));
        }
        return clone;
    }
    
    public static int countGames(int dog, HashMap<Integer, Boolean> dogs) {
        if (dogs.size() == 1) {
            return 1;
        } else {
            boolean t = dogs.remove(dog);;
            if (t) {
                return 1 + (dogs.containsKey(dog + 1) ? countGames(dog + 1, cloneMap(dogs)) : 0) 
                        + (dogs.containsKey(dog + 2) ? countGames(dog + 2, cloneMap(dogs)) : 0)
                        + (dogs.containsKey(dog - 1) ? countGames(dog - 1, cloneMap(dogs)) : 0)
                        + (dogs.containsKey(dog - 2) ? countGames(dog - 2, cloneMap(dogs)) : 0);
            } else {
                return 1 + (dogs.containsKey(dog + 1) ? countGames(dog + 1, cloneMap(dogs)) : 0) 
                        + (dogs.containsKey(dog - 1) ? countGames(dog - 1, cloneMap(dogs)) : 0);
            }
                
        }
    }

    public static void main(String[] args) {
        FastReader f = new FastReader();
        int t = f.nextInt();
        for (int i = 0; i < t; i++) {
            HashMap<Integer, Boolean> dogs = new HashMap<Integer, Boolean>();
            int n = f.nextInt();
            for (int j = 0; j < n; j++) {
                dogs.put(j, f.nextInt() == 2 ? true : false);
            }
            System.out.println(countGames(0, dogs));
        }

    }

}
