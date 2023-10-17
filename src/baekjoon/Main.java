package baekjoon;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//문제 풀이용
public class Main {
    static int N, M;

    static int[] dx = {-1, 1, 0, 0 };
    static int[] dy = {0 , 0, -1, 1};
    static int[][] map;
    static int[][] dis;

    static Queue<Point> Q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[M][N];
        dis = new int[M][N];
        int max = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    Q.offer(new Point(i, j));
                }
            }
        }

        BFS();
        System.out.println(dis[N-1][M-1] + 1);
    }

    public static void DFS(int x, int y, int heigh) {

    }

    public static void BFS() {
        //BFS
        while (!Q.isEmpty()) {
            Point tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0) {
                    map[nx][ny] = 0;
                    Q.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }

    }

}
