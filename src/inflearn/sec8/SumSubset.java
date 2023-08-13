package inflearn.sec8;

import inflearn.Main;
import java.util.Scanner;

public class SumSubset {
    static int max, N;
    static int total = 0;
    public void DFS(int L, int sum, int[] arr) {
        if(sum > max) return;
        if (L == N) {
            if (total < sum) {
                total = Math.max(total, sum);
            }
        } else {
            DFS(L + 1, sum + arr[L], arr);
            DFS(L + 1, sum , arr);
        }
    }

    public static void main(String[] args) {
        SumSubset M = new SumSubset();
        Scanner sc = new Scanner(System.in);

        max = sc.nextInt();
        N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        M.DFS(0,0,arr);
        System.out.println(total);
    }
}
