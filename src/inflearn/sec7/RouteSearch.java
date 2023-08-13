package inflearn.sec7;

import java.util.Scanner;

public class RouteSearch {
    static int answer,n, m;
    static int[] ch;
    static int[][] graph;

    public void routeDFS(int v) {
        if (v == n) {
            answer++;
        } else {
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    routeDFS(i);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        RouteSearch M = new RouteSearch();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n+1][n+1];
        ch = new int[m];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1;
        M.routeDFS(1);
        System.out.println(answer);
    }
}
