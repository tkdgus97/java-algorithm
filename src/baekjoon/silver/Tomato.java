package baekjoon.silver;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//7576
public class Tomato {
    static int N, M;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map, dis;
    static boolean[][] visit;

    static Queue<Point> Q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[M][N];
        dis = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    Q.offer(new Point(i, j));
                }
            }
        }
        System.out.println(BFS());
    }

    public static int BFS() {
        while(!Q.isEmpty()){
            Point tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < M && ny < N && map[nx][ny] == 0) {
                    Q.offer(new Point(nx, ny));
                    map[nx][ny] = map[tmp.x][tmp.y] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    return -1;
                }
                max = Math.max(max, map[i][j]);
            }
        }

        if (max == 1) {
            return 0;
        } else {
            return max - 1;
        }
    }


    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
