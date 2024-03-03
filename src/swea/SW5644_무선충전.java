package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW5644_무선충전 {
    private static class BC {
        int x;
        int y;
        int charge, p;

        public BC(int x, int y, int charge, int p) {
            this.x = x;
            this.y = y;
            this.charge = charge;
            this.p = p;
        }
    }

    private static int[] dx = {0, -1, 0, 1, 0};
    private static int[] dy = {0, 0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //테스트 케이스 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int test_case = 1; test_case <= t; test_case++) {
            //-------------- 입력 --------------
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());

            BC[] batteries = new BC[A];

            int[] aMove = new int[M];
            int[] bMove = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                aMove[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                bMove[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int range = Integer.parseInt(st.nextToken());
                int charge = Integer.parseInt(st.nextToken());
                batteries[i] = new BC(y - 1, x - 1, charge, range);
            }

            int result = simulation(aMove, bMove, batteries, M);
            //-------------- 입력 --------------
            sb.append("#").append(test_case).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static int simulation(int[] aMove, int[] bMove, BC[] batteries, int M) {
        int ax, ay;
        ax = ay = 0;

        int bx, by;
        bx = by = 9;

        int total = charge(ax, ay, bx, by, batteries);
        for (int i = 0; i < M; i++) {
            ax += dx[aMove[i]];
            ay += dy[aMove[i]];

            bx += dx[bMove[i]];
            by += dy[bMove[i]];

            total += charge(ax, ay, bx, by, batteries);
        }

        return total;
    }

    private static int charge(int ax, int ay, int bx, int by, BC[] batteries) {
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        for (int i = 0; i < batteries.length; i++) {
            if (Math.abs(batteries[i].x - ax) + Math.abs(batteries[i].y - ay) <= batteries[i].p) {
                aList.add(i);
            }
            if (Math.abs(batteries[i].x - bx) + Math.abs(batteries[i].y - by) <= batteries[i].p) {
                bList.add(i);
            }
        }

        int max = 0;
        if (aList.size() > 0 && bList.size() > 0) {
            for (int i : aList) {
                int tmp = 0;
                for (int j : bList) {
                    tmp = 0;
                    if (i == j) {
                        tmp += batteries[i].charge;
                    } else {
                        tmp += batteries[i].charge;
                        tmp += batteries[j].charge;
                    }
                    max = Math.max(tmp, max);
                }
            }
        } else if (aList.size() > 0) {
            for (int i : aList) {
                max = Math.max(max, batteries[i].charge);
            }
        } else if (bList.size() > 0) {
            for (int i : bList) {
                max = Math.max(max, batteries[i].charge);
            }
        }
        return max;
    }
}
