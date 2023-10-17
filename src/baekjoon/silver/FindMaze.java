package baekjoon.silver;

import baekjoon.Main;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//2178번
public class FindMaze {
    static int N, M;

    static int[] dx = {-1, 1, 0, 0 };
    static int[] dy = {0 , 0, -1, 1};
    static int[][] map;
    static int[][] dis;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        dis = new int[N][M];
        int max = 0;
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        //시작
        BFS(0,0);

        System.out.println(dis[N-1][M-1] + 1);
    }

    public static void DFS(int x, int y, int heigh) {

    }

    public static void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        //최초 받은 0,0 offer
        Q.offer(new Point(x, y));
        //진입 불가 처리
        map[x][y] = 0;
        //BFS
        while (!Q.isEmpty()) {
            Point tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                //이동했을 때 x,y 값이 0보다 커야하고 사이즈보다 작아야 하며 갈 수 있는 길(1)이어야함
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 1) {
                    //이미 간 곳은 막음
                    map[nx][ny] = 0;
                    Q.offer(new Point(nx, ny));
                    //거리 표시
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
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
