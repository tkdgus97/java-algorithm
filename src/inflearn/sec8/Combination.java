package inflearn.sec8;

import java.util.Scanner;

public class Combination {
    static int[][] arr;

    public int DFS(int n, int r) {
        if (arr[n][r] > 0) {
            return arr[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        }
        else return arr[n][r] = DFS(n - 1, r-1) + DFS(n-1 , r);
    }

    public static void main(String[] args) {
        Combination M = new Combination();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();

        arr = new int[n+1][n+1];

        System.out.println(M.DFS(n,r));
    }
}
