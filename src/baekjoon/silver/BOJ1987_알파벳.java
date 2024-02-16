package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1987_알파벳 {
    private static int[] dx = new int[]{-1, 0, 1, 0};
    private static int[] dy = new int[]{0, 1, 0, -1};

    private static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

//        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - 'A';
            }
        }

        DFS(0, 0, N, M, 0, arr, new boolean[N][M], 1);
        System.out.println(result);
    }

    private static void DFS(int x, int y, int N, int M, int check, int[][] map, boolean[][] visit, int count) {
        check = (check | (1 << map[x][y]));
        visit[x][y] = true;
        result = Math.max(count, result);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if ((nx >= 0 && nx < N) && (ny >= 0 && ny < M) && !visit[nx][ny] && ((check & (1 << map[nx][ny])) == 0)) {
                DFS(nx, ny, N, M, check, map, visit, count + 1);
                visit[x][y] = false;
            }
        }
    }
}
