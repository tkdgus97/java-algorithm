package baekjoon.gold;

import java.util.Scanner;

//10026
public class RGcolorBlindness {

    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new char[N][N];
        visit = new boolean[N][N];
        res = 0;
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    DFS(i,j);
                    res++;
                }
            }
        }
        System.out.print(res + " ");
        res = 0;
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    DFS(i,j);
                    res++;
                }
            }
        }
        System.out.print(res);
    }


    public static void DFS(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if ((nx >= 0 && nx < N ) && (ny >= 0 && ny < N) && !visit[nx][ny] && map[nx][ny] == map[x][y])  {
                DFS(nx, ny);
            }
        }
    }
}
