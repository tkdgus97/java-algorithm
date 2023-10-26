package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2644 {
    static int[][] map;
    static int[] dis;
    static boolean[] dVisit;
    static int n;
    public void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //최대
        n = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        dVisit = new boolean[n + 1];
        dis = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x =Integer.parseInt(st.nextToken());
            int y =Integer.parseInt(st.nextToken());

            map[x][y] = 1;
            map[y][x] = 1;
        }
        dis[start] = 0;
        DFS(start);
        System.out.println(dis[end] > 0 ? dis[end] : -1);
    }

    public static void DFS(int s) {
        dVisit[s] = true;
        for (int i = 1; i <= n; i++) {
            if (map[s][i] == 1 && !dVisit[i]) {
                dis[i] = dis[s] + 1;
                DFS(i);
            }
        }
    }
}
