package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S2109 {
    public void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<Tmp> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (d > max) max = d;
            list.add(new Tmp(p,d));
        }
        Collections.sort(list);
        int j = 0, answer = 0;

        for (int i = max; i >= 1; i--) {
            for (; j < N; j++) {
                if (list.get(j).date < i) {
                    break;
                }
                pq.offer(list.get(j).price);
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
        System.out.println(answer);
    }

    private  static class Tmp implements Comparable<Tmp> {
        int price;
        int date;

        public Tmp(int price, int date) {
            this.price = price;
            this.date = date;
        }

        @Override
        public int compareTo(Tmp tmp) {
            return tmp.date - this.date;
        }
    }
}
