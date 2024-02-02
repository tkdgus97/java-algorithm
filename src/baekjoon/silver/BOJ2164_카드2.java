package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2164_카드2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            Q.add(i);
        }

        while (Q.size() != 1) {
            Q.poll();
            Q.offer(Q.poll());
        }

        System.out.println(Q.poll());
    }
}
