package inflearn.sec7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphMinSearch {
    static int[] dis, ch;
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;

    public void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        q.add(v);
        while (!q.isEmpty()) {
            int cv = q.poll();
            for (int nv: graph.get(cv)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    q.add(nv);
                    dis[nv] = dis[cv] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphMinSearch M = new GraphMinSearch();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        ch = new int[n + 1];
        dis = new int[n + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        M.BFS(1);
        for (int i = 1; i < dis.length; i++) {
            System.out.println(i + ":" + dis[i]);
        }
    }
}
