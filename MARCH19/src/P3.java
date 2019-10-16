import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P3 {

    public static void main(String[] args) throws IOException {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(s.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(s.readLine());
            int count = 0;
            int full = 0;
            ArrayList<boolean[]> strings = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                String temp = s.readLine();
                boolean e = true;
                boolean[] te = new boolean[5];
                int l = temp.length();
                for (int k = 0; k < l; k++) {
                    char c = temp.charAt(k);
                    switch(c) {
                    case 'a':
                        te[0] = true; break;
                    case 'e':
                        te[1] = true; break;
                    case 'i':
                        te[2] = true; break;
                    case 'o':
                        te[3] = true; break;
                    case 'u':
                        te[4] = true; break;
                    default:
                        break;
                    }
                    if (te[0] && te[1] && te[2] && te[3] && te[4]) {
                        e = false;
                        break;
                    }
                }
                if (e) {
                    strings.add(te);
                } else {
                    full++;
                }
            }
            int size = strings.size();
            for (int j = 0; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    boolean f = true;
                    for (int l = 0; l < 5; l++) {
                        if (!strings.get(j)[l] && !strings.get(k)[l]) {
                            f = false;
                            break;
                        }
                    }
                    if (f) {
                        count++;
                    }
                }
            }
            System.out.println(count + full * size + (full * (full - 1)) / 2);
        }
        s.close();

    }

}
