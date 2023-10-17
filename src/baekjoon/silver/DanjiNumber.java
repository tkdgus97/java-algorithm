package baekjoon.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DanjiNumber {
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, res;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        List<Integer> cntList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    DFS(i,j);
                    cntList.add(cnt);
                    cnt = 0;
                }
            }
        }

        Collections.sort(cntList);
        System.out.println(cntList.size());
        for (int v : cntList) {
            System.out.println(v);
        }
//        BFS(0,0);
    }


    public static void DFS(int x, int y) {
        cnt++;
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if ((nx >= 0 && nx < N ) && (ny >= 0 && ny < N) && !visit[nx][ny] && map[nx][ny] == 1)  {
                DFS(nx, ny);
            }
        }
    }
}
