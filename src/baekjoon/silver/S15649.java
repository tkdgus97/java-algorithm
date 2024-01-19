package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S15649 {
    static boolean[] visit;
    static int[] ch;
    static int N, M;
    public void main() throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1];
        ch = new int[M];

        DFS(0);

    }

    public static void DFS(int L) {
        if (L == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(ch[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N ; i++) {
            if (!visit[i]) {
                visit[i] = true;
                ch[L] = i;
                DFS(L + 1);
                visit[i] = false;
            }
        }
    }
}
