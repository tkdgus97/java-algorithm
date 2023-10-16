package baekjoon.silver;

import java.util.Scanner;

public class LuckyStraight {
    public void solution() {
        Scanner sc = new Scanner(System.in);

        String N  = sc.next();

        int t1 = 0;
        int t2 = 0;
        for (int i = 0; i < N.length(); i++) {
            if (i < N.length() / 2) {
                t1 += Character.getNumericValue(N.charAt(i));
            } else {
                t2 += Character.getNumericValue(N.charAt(i));
            }
        }

        if (t1 == t2) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
