package inflearn.sec7;

import inflearn.sec8.SumSubset;
import java.util.Scanner;

public class MaxGrade {
    static int maxTime, N;
    static int total = 0;
    public void DFS(int L, int sum, int t, int[] score, int[] time) {
        if (t > maxTime) {
            return;
        }
        if (L == N) {
            if (total < sum) {
                total = Math.max(total, sum);
            }
        } else {
            DFS(L + 1, sum + score[L], t + time[L], score, time);
            DFS(L + 1, sum, t, score, time);

        }
    }

    public static void main(String[] args) {
        MaxGrade M = new MaxGrade();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        maxTime = sc.nextInt();

        int[] arr = new int[N];
        int[] arr2 = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            arr2[i] = sc.nextInt();
        }

        M.DFS(0,0,0, arr, arr2);
        System.out.println(total);
    }
}
