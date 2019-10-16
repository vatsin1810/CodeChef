import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class P3Alt {

    public static void main(String[] args) throws IOException {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        long t = Integer.parseInt(s.readLine());
        for (int m = 0; m < t; m++) {
            int n = Integer.parseInt(s.readLine());
            long count = 0;
            HashMap<Integer, Integer> strings = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String temp = s.readLine();
                char a = '0', e = '0', i = '0', o = '0', u = '0';
                long r = temp.length();
                for (int k = 0; k < r; k++) {
                    char c = temp.charAt(k);
                    switch(c) {
                    case 'a':
                        a = '1'; break;
                    case 'e':
                        e = '1'; break;
                    case 'i':
                        i = '1'; break;
                    case 'o':
                        o = '1'; break;
                    case 'u':
                        u = '1'; break;
                    default:
                        break;
                    }
                    if (a == '1' && e == '1' && i == '1' && o == '1' && u == '1') {
                        break;
                    }
                }
                int d = Integer.parseInt(String.valueOf(a) + e + i + o + u, 2);
                if (strings.containsKey(d)) {
                    strings.put(d, strings.get(d) + 1);
                } else {
                    strings.put(d, 1);
                }
            }
            long size = strings.size();
            Integer[] arr = new Integer[32];
            strings.keySet().toArray(arr);
            for (int j = 0; j < size; j++) {
                for (int k = j; k < size; k++) {
                    if ((((int) arr[j]) | ((int) arr[k])) == 31) {
                        int ja = (int) strings.get(arr[j]);
                        int ka = (int) strings.get(arr[k]);
                        if (j != k)
                            count += (ka * ja);
                        else
                            count += (ka * (ka - 1)) / 2;
                    }
                }
            }
            System.out.println(count);
        }
        s.close();
    }
}

