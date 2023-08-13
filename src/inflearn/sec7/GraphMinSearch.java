package inflearn.sec7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphMinSearch {

    static int answer,n, m;
    static int[] ch;

    static ArrayList<ArrayList<Integer>> graph;
    Queue<Integer> q = new LinkedList<>();
    public void routeDFS() {
        q.add(1);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                q.poll();

            }
        }
        if (ch[v] != 0) {
            return;
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] != 1) {

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
//        M.routeDFS(1);
        System.out.println(answer);
    }
}
