package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsAndBfs {
    //BFS에 쓰일 이차원 배열
    static int[][] graph = new int[1001][1001];
    static boolean[] visit = new boolean[10001];
    //N은 DFS, BFS 메소드에도 사용되어야 하기 때문에 필드로 선언
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        //간선을 두개의 그래프 배열에 똑같이 저장해 준다.
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = graph[v][u] = 1;
        }
        DFS(V);
        System.out.println();
        BFS(V);
    }

    public static void DFS(int start) {
        visit[start] = true;
        System.out.print(start + " ");
        for (int i = 0; i <= N; i++) {
            if (graph[start][i] == 1 && !visit[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int start) {
        Queue<Integer> Q = new LinkedList<>();
        boolean[] Bvisit = new boolean[10001];
        Bvisit[start] = true;
        Q.offer(start);

        while (!Q.isEmpty()) {
            int n = Q.poll();
            System.out.print(n + " ");
            for (int i = 1; i <= N; i++) {
                if (!Bvisit[i] && graph[n][i] == 1) {
                    Bvisit[i] = true;
                    Q.add(i);
                }
            }
        }
    }


}
