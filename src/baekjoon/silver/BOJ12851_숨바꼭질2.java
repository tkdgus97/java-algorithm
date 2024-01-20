package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12851_숨바꼭질2 {
    private static int cnt = 0;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if (N >= K) {
            System.out.println(N - K);
            System.out.println(1);
        } else {
            System.out.println(bfs(N, K));
            System.out.println(cnt);
        }
    }

    private static int bfs(int start, int target) {
        int min = Integer.MAX_VALUE;

        final int[] d = new int[]{1, -1, 2};
        int[] visit = new int[100001];
        visit[start] = 1;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(start);

        while (!Q.isEmpty()) {
            int tmp = Q.poll();

            if (min < visit[tmp]) break;
            for (int i = 0; i < d.length; i++) {
                int next = i == 2 ? tmp * d[i] : tmp + d[i];
                if (next == target) {
                    min = visit[tmp];
                    cnt++;
                }
                if (next < 0 || next > visit.length - 1) {
                    continue;
                }
                if (visit[next] == 0 || visit[next] == visit[tmp] + 1) {
                    visit[next] = visit[tmp] + 1;
                    Q.offer(next);
                }
            }
        }
        return min;
    }
}
