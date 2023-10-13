package baekjoon;

import java.util.Scanner;
import java.util.Stack;

//문제 풀이용
public class Main {

//    public static String sol(int n, int k) {
//        return null;
//    }
    static int[][] map;
    static boolean[][] visit;
    static int[] disX = {0, 0, -1, 1};
    static int[] disY = {-1, 1, 0, 0};
    static int x, y, k;
    static int nowX, nowY;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        //테스트 케이스 만큼 반복
        for (int i = 0; i < tc; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            k = sc.nextInt();

            map = new int[y][x];
            visit = new boolean[y][x];

            for (int j = 0; j < k; j++) {
                int tmpx = sc.nextInt();
                int tmpy = sc.nextInt();
                map[tmpy][tmpx] = 1;
            }

            for (int j = 0; j < y; j++) {
                for (int l = 0; l < x; l++) {
                    System.out.print(map[j][l] + " ");
                }
                System.out.println();
            }

            int count = 0;

            for (int j = 0; j < y; j++) {
                for (int l = 0; l < x; l++) {
                    if (map[j][l] == 1 && !visit[j][l]) {
                        DFS(j, l);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }

    static void DFS(int ly, int lx) {
        visit[ly][lx] = true;
        for (int i = 0; i < 4; i++) {
            nowX = lx + disX[i];
            nowY = ly + disY[i];
            if (check() && map[nowY][nowX] == 1 && !visit[nowY][nowX]) {
                DFS(nowY, nowX);
            }
        }

    }

    static public boolean check() {
        return (nowX < x && nowX >= 0 && nowY < y && nowY >= 0);
    }
}
