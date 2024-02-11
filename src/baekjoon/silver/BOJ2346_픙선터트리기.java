package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ2346_픙선터트리기 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 2; i <= N; i++) {
            dq.add(i);
        }

        int move = arr[1];
        sb.append("1 ");
        while(!dq.isEmpty()) {
            if (move > 0) {
                for (int i = 1; i < move; i++) {
                    dq.addLast(dq.pollFirst());
                }
                int poll = dq.poll();
                move = arr[poll];
                sb.append(poll).append(" ");
            } else if (move < 0){
                for (int i = 1; i < -move; i++) {
                    dq.addFirst(dq.pollLast());
                }
                int poll = dq.pollLast();
                move = arr[poll];
                sb.append(poll).append(" ");
            }
        }
        System.out.println(sb);
    }
}
