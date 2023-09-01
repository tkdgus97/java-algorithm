package baekjoon.step;

import java.util.Scanner;

//소수
public class B2581 {
    static boolean[] ch;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int min = Integer.MAX_VALUE;
        int sum = 0;

        ch = new boolean[N + 1];

        ch[0] = ch[1] = true;

        for (int i = 2; i <= N; i++) {
            if (!ch[i]) {
                for (int j = i + i; j <= N; j += i) {
                    ch[j] = true;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (!ch[i]) {
                sum += i;
                min = Math.min(i, min);
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }

    }
}
