package inflearn.sec8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ExchangeCoin {
    static Integer[] coin;
    static int n, amount;
    static int result = Integer.MAX_VALUE;
    public void DFS(int L, int sum) {
        if (sum > amount) {
            return;
        }
        if (L >= result) {
            return;
        }
        if (sum == amount) {
            result = Math.min(result, L);
        } else {
            for (int i = 0; i < n; i++) {
                DFS(L + 1, sum + coin[i]);
            }
        }
    }

    public static void main(String[] args) {
        ExchangeCoin M = new ExchangeCoin();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        coin = new Integer[n];

        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }

        amount = sc.nextInt();

        Arrays.sort(coin, Collections.reverseOrder());
        M.DFS(0,0);
        System.out.println(result);
    }
}
