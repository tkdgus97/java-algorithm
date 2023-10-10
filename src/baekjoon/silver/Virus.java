package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Virus {
    static int[][] graph = new int[1001][1001];
    static boolean[] visit = new boolean[10001];
    static int N;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        //간선을 두개의 그래프 배열에 똑같이 저장해 준다.
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = graph[v][u] = 1;
        }
        DFS(1);
        System.out.println(cnt);
    }

    public static void DFS(int start) {
        visit[start] = true;
        for (int i = 0; i <= N ; i++) {
            if (!visit[i] && graph[start][i] == 1) {
                DFS(i);
                cnt++;
            }
        }
    }
}
