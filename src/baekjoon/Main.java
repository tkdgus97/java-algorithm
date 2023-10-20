package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//문제 풀이용
public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map, dis;
    static boolean[][] visit;
    static int N,M, res, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dis = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        BFS(0,0);

        System.out.println(dis[N - 1][M -1] + 1);
    }

    public static void BFS(int x, int y){
        Queue<Point> Q = new LinkedList<>();
        visit[x][y] = true;

        Q.offer(new Point(x, y));

        while (!Q.isEmpty()) {
            Point p = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if ((nx >= 0 && nx < N) && (ny >= 0 && ny < M) && map[nx][ny] == 1 && !visit[nx][ny]) {
                    dis[nx][ny] = dis[p.x][p.y] + 1;
                    visit[nx][ny] = true;
                    Q.offer(new Point(nx, ny));
                }
            }
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
