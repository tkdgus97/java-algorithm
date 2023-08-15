package inflearn.sec8;

import java.util.Scanner;

public class Permutation {

    static int[] ch, arr, pm;
    static int n, m;
    public void DFS(int L) {
        if (L == n) {
            for (int i = 0; i < m; i++) {
                System.out.print(pm[i]);
            }
            System.out.println();
        } else {
            for (int i = 0; i < m; i++) {
                if (ch[i] != 1) {
                    ch[i] = 1;
                    pm[L] = arr[i];
                    DFS(L + 1);
                    ch[i] = 0;
                }
            }
            ch[L] = 0;
        }
    }
    public static void main(String[] args) {
        Permutation M = new Permutation();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        pm = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        M.DFS(0);
    }
}
