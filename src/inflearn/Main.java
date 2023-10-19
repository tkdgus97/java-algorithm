package inflearn;

import java.util.Scanner;

public class Main {
//    public void solution(int n) {
//
//    }

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[] map;
    static int answer = 0;
    static int N, M;
    static int[] pm;
    static boolean[] visit;

    public static void main(String[] args) {
//        Main M = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N];
        pm = new int[M];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            map[i] = sc.nextInt();
        }

        DFS(0);

    }
    protected static void DFS(int L) {
        if (L == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(pm[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < N; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    pm[L] = map[i];
                    DFS(L + 1);
                    visit[i] = false;
                }
            }
        }
    }
}
