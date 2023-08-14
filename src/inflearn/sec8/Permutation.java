package inflearn.sec8;

import java.util.Scanner;

public class Permutation {
    static int[] pm;
    static int n,m;
    public void DFS(int L) {
        if (L == m) {
            for (int x : pm) {
                System.out.print(x +  " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                pm[L] = i;
                DFS(L +1);
            }
        }
    }

    public static void main(String[] args) {
        Permutation M = new Permutation();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];
        M.DFS(0);
    }
}
