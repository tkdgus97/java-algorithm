package baekjoon.silver;

import java.util.Scanner;

public class FindFountain {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int g = 0;
        int sum = 0;
        while (sum < X ) {
            g++;
            sum += g;
        }
        int up, dw;
        int w = g - (sum - X);

        if (g % 2 == 0) {
            up = 1;
            dw = g;
        } else {
            up = g;
            dw = 1;
        }
        int i = 1;
        while (i < w) {
            i++;
            if (g % 2 == 0) {
                up++;
                dw--;
            } else {
                up--;
                dw++;
            }
        }
        System.out.println(up + "/" + dw);
    }
}
