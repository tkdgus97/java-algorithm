package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G1715 {
    public void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(Long.parseLong(st.nextToken()));
        }

        long answer = 0;

        while (pq.size() > 1) {
            long a1 = pq.poll();
            long a2 = pq.poll();

            answer += (a1 + a2);
            pq.add(a1+a2);
        }

        System.out.println(answer);
    }
}
