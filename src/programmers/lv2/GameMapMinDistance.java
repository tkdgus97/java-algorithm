package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapMinDistance {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int solution(int[][] maps) {
        int answer = 0;
        return BFS(maps);
    }

    static int BFS(int[][] maps) {
        int X = maps.length;
        int Y = maps[0].length;

        int[][] distance = new int[X][Y];
        boolean[][] visit = new boolean[X][Y];

        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(0,0));
        visit[0][0] = true;

        while (!Q.isEmpty()) {
            Point p = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if ((nx >= 0 && nx < X ) && (ny >= 0 && ny < Y) && maps[nx][ny] == 1 && !visit[nx][ny]) {
                    distance[nx][ny] = distance[p.x][p.y] + 1;
                    visit[nx][ny] = true;
                    Q.offer(new Point(nx, ny));
                }
            }
        }

        if (distance[X-1][Y-1] == 0) {
            return -1;
        }
        return distance[X-1][Y-1] + 1;
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
