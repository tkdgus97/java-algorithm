package baekjoon.silver.lv5;

import java.util.Scanner;

public class Sosu {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int N = sc.nextInt();

        int result = 0;

        int v = x % y;

        for (int i = 1; i <= N - 1; i++) {
            v *= 10;
            v = v % y;
        }

        System.out.println(v*10 / y);
    }
}
