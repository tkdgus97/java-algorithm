package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1992_쿼드트리 {
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

//        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < N; j++) {
                map[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        backTrack(0, 0, N, map);

        System.out.println(result);
    }

    private static void backTrack(int r, int c, int size, int[][] map) {
        if (size == 1) {
            result.append(map[r][c]);
            return;
        }
        int s = map[r][c];
        boolean flag = true;
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (s != map[i][j]) {
                    flag = false;
                    break;
                }
                if (!flag) {
                    break;
                }
            }
        }
        if (flag) {
            result.append(s);
            return;
        }

        result.append("(");
        backTrack(r, c, size / 2, map);
        backTrack(r, c + size / 2, size / 2, map);
        backTrack(r + size / 2, c, size / 2, map);
        backTrack(r + size / 2, c + size / 2, size / 2, map);
        result.append(")");
    }
}
