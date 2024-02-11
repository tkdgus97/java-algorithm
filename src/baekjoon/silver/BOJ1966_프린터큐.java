package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1966_프린터큐 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int idx = 0;
            st = new StringTokenizer(br.readLine());

            Queue<Integer> scoreQ = new LinkedList<>();
            Queue<Integer> Q = new LinkedList<>();

            for (int j = 0; j < N; j++) {
                scoreQ.add(Integer.parseInt(st.nextToken()));
                Q.add(j);
            }

            int max = Collections.max(scoreQ);

            while (!Q.isEmpty()) {
                if (scoreQ.peek() < max) {
                    scoreQ.add(scoreQ.poll());
                    Q.add(Q.poll());
                } else {
                    scoreQ.poll();
                    int now = Q.poll();
                    idx += 1;
                    if (now == M){
                        sb.append(idx).append("\n");
                        break;
                    }
                    max = Collections.max(scoreQ);
                }
            }

        }
        System.out.println(sb);
    }
}
