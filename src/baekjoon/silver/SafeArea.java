package baekjoon.silver;

import java.util.Scanner;

//2468번
public class SafeArea {
    static int N;

    static int[] dx = {-1, 1, 0, 0 };
    static int[] dy = {0 , 0, -1, 1};
    static int[][] map;
    static boolean[][] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] > max) {
                    max = map[i][j];
                }
            }
        }
        int res = 0;

        for (int i = 0; i <= max; i++) {
            int cnt = 0;
            visit = new boolean[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] > i && !visit[j][k]) {
                        cnt++;
                        DFS(j, k, i);
                    }
                }
            }
            res = Math.max(res, cnt);
        }
        System.out.println(res);
    }

    public static void DFS(int x, int y, int heigh) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] > heigh && !visit[nx][ny]) {
                DFS(nx, ny, heigh);
            }
        }
    }
}
