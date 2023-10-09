package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public void solution(int n) {

    }

    static int N;
    static int[] ch;
    public void DFS(int L) {
        if (L == N + 1) {
            for (int i = 1; i <= N; i++) {
                if (ch[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            return;
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L+1);
        }
    }

    public static void main(String[] args) {
        Main M = new Main();
        N = 3;
        ch = new int[N + 1];
        M.DFS(1);
    }
}
