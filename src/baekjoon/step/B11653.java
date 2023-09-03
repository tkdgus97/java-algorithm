package baekjoon.step;

import java.util.Scanner;

public class B11653 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        if (N == 1) {
            return;
        }

        for (int i = 2; i <= N ; i++) {
            while (N % i == 0) {
                if (N % i == 0) {
                    sb.append(i).append("\n");
                    N = N / i;
                }
            }
        }

        System.out.println(sb);
    }
}
