package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1497_기타콘서트 {

    private static int min = -1;

    private static int[] countArr;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] info = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String possible = st.nextToken();

            for (int j = 0; j < M; j++) {
                if (possible.charAt(j) == 'Y') {
                    if (min == -1) {
                        min = 1;
                    }
                    info[i][j] = true;
                }
            }
        }

        countArr = new int[M + 1];
        Arrays.fill(countArr, Integer.MAX_VALUE);
        if (min == -1) {
            System.out.println(-1);
        } else {
            min = Integer.MAX_VALUE;
            dfs(0, M,N,0, new boolean[M], info);
            System.out.println(countArr[M]);
        }


    }

    private static void dfs(int L, int M, int N, int count, boolean[] now, boolean[][] info) {
        if (countArr[count] < L) {
            return;
        }
        //종료 조건
        if (L == N) {
            countArr[count] = Math.min(L, countArr[count]);
            return;
        }

        for (int i = 0; i < M; i++) {
            if (info[L][i] && !now[i]) {
                now[i] = true;
                count += 1;
            }
        }
        countArr[count] = L + 1;
        dfs(L  + 1, M, N, count, now, info);
        for (int i = 0; i < M; i++) {
            if (!info[L][i] && now[i]) {
                now[i] = false;
                count -= 1;
            }
        }
        countArr[count] = L;
        dfs(L + 1, M, N, count, now, info);
    }
}
