import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class P4Alt {
    
    private static Random generator = new Random();
    
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
    
    void quickSort (int[] array, int low, int high) {

        if (low < high) {
            int pi = partition (array, low, high);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }

    }

    private static int partition(int[] array, int begin, int end) {
        int index = begin + generator.nextInt(end - begin + 1);
        int pivot = array[index];
        swap(array, index, end); 
        for (int i = index = begin; i < end; ++ i) {
            if (array[i] <= pivot) {
                swap(array, index++, i);
            }
        }
        swap(array, index, end); 
        return (index);
    }

    
    private static int orderStatistic(int[] A, int k, int start, int end) {
        int pivotPosition = partition(A, start, end);

        while (pivotPosition != k) {
            if (k < pivotPosition) {
                end = pivotPosition - 1;
            } else {
                start = pivotPosition + 1;
            }

            pivotPosition = partition(A, start, end);
        }

        return A[k];
    }

    public static int kthLargest(int[] A, int k) {
        return orderStatistic(A, A.length - k - 1, 0, A.length - 1);
    }

    public static int kthLargest1Based(int[] A, int k) {
        return kthLargest(A, k - 1);
    }

    public static int kthLargestSafe(int[] A, int k) {
        Arrays.sort(A);
        return A[A.length - k - 1];
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
    public static int findMax(int[] A) {
        int max = A[0];
        for (int i : A) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
    
    public static boolean contains (int[] A, int k, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (A[k] == i) {
                return true;
            }
        }
        return false;
    }
    
    public static int freq (int[] A, int k, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (A[i] == k) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FastReader f = new FastReader();
        int t = f.nextInt();
        for (int z = 0; z < t; z++) {
            int n = f.nextInt();
            int k = f.nextInt();
            int count = 0;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = f.nextInt();
            }
            for (int i = 0; i < n; i++) {
                int x = arr[i];
                int xfr = 1;
                boolean beaut = x == 1;
                if (beaut)
                    count++;
                int temp = 0;
                for (int j = i + 1; j < n; j++) {
                    int s = j - i + 1;
                    int m = (k + s - 1) / s;
                    int l = (k - m * s + m - 1) / m;
                    if (arr[j] > x || l != temp) {
                        x = orderStatistic(arr, s - l - 1, i, j);
                        xfr = freq(arr, x, i, j);
                        temp = l;
                        beaut = contains(arr, xfr, i, j);
                    } else if (arr[j] == x) {
                        xfr++;
                        beaut = contains(arr, xfr, i, j);
                    }
                    if (beaut) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }

}
