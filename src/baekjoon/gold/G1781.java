package baekjoon.gold;

import baekjoon.Main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G1781 {
    public void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<Tmp> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (d > max) max = d;
            list.add(new Tmp(d, c));
        }
        //정렬하는 이유 : i를 줄이면서 날짜별로 비교
        Collections.sort(list);
        int j = 0, answer = 0;

        for (int i = max; i >= 1; i--) {
            for (; j < N; j++) {
                if (list.get(j).deadLine < i) {
                    break;
                }
                pq.offer(list.get(j).cup);
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
        System.out.println(answer);
    }
    private static class Tmp implements Comparable<Tmp> {
        int deadLine;

        int cup;

        public Tmp(int deadLine, int cup) {
            this.deadLine = deadLine;
            this.cup = cup;
        }

        @Override
        public int compareTo(Tmp tmp) {
            return tmp.deadLine - this.deadLine;
        }
    }
}
