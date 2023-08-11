package inflearn.sec7;

import java.util.ArrayList;
import java.util.Scanner;

public class RouteSearch2 {

    static int answer, n, m;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph;

    public void routeDFS(int v) {
        if (v == n) {
            answer++;
        } else {
            for (int nv : graph.get(v)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    routeDFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        RouteSearch2 M = new RouteSearch2();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        ch = new int[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        M.routeDFS(1);
        System.out.println(answer);
    }
}
