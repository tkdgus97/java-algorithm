package baekjoon.silver;

import java.util.Scanner;

public class OrganicVechu {

    static int[][] board;
    static boolean[][] visit;
    static int N,M;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        //테스트 케이스만큼 반복
        for (int i = 0; i < T; i++) {
            N = sc.nextInt();//가로 10
            M = sc.nextInt();//세로 8
            int K = sc.nextInt();//배추 정보

            board = new int[M][N];
            visit = new boolean[M][N];
            for (int j = 0; j < K; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                board[y][x] = 1;
            }

            int count = 0;
            //가로만큼 8
            for (int j = 0; j < M; j++) {
                //세로만큼 10 0,1 0,2
                for (int k = 0; k < N; k++) {
                    if (board[j][k] == 1 && !visit[j][k]) {
                        count++;
                        DFS(j,k);
                    }
                }
            }
            System.out.println(count);
        }
    }
    static void DFS(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx>=0 && ny>=0 && nx<M && ny<N && !visit[nx][ny]&& board[nx][ny] == 1) {
                DFS(nx, ny);
            }
        }
    }
}
