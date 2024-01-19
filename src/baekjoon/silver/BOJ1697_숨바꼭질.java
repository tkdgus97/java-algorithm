package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697_숨바꼭질 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    private static int bfs(int start, int target) {
        if (start == target) {
            return 0;
        }

        final int[] d = new int[]{1, -1, 2};
        int[] visit = new int[100001];

        visit[start] = 1;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(start);

        while (!Q.isEmpty()) {
            int tmp = Q.poll();
            for (int i = 0; i < d.length; i++) {
                int next = i == 2 ? tmp * d[i] : tmp + d[i];
                if (next == target) {
                    return visit[tmp];
                }
                if (next >= 0 && next < visit.length && visit[next] == 0) {
                    visit[next] = visit[tmp] + 1;
                    Q.offer(next);
                }
            }
        }
        return 0;
    }
}
