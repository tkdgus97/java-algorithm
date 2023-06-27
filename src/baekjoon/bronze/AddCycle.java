package baekjoon.bronze;

import java.util.Scanner;

/**
 * 1110번 - 더하기 사이클
 */
public class AddCycle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int count = 0;
        int copy = n;

        do {
            if (n < 10) {
                n = (n * 10) + n;
            } else {
                n = ((n % 10) * 10) + (((n / 10) + (n % 10)) % 10);
            }
            count++;
        } while (copy != n);
        System.out.println(count);
    }
}
