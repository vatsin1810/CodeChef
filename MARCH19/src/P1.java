import java.util.Scanner;

public class P1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int po = 0, ne = 0;
            int n = s.nextInt();
            for (int j = 0; j < n; j++) {
                int m = s.nextInt();
                if (m > 0) {
                    po++;
                } else {
                    ne++;
                }
            } if (po == 0) {
                System.out.println(ne + " " + ne);
            } else if (ne == 0) {
                System.out.println(po + " " + po);
            } else if (po > ne) {
                System.out.println(po + " " + ne);
            } else {
                System.out.println(ne + " " + po);
            }
        }
        s.close();
    }
}
