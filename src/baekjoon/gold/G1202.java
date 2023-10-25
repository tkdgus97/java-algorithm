package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G1202 {

    public void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Tmp> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            list.add(new Tmp(w,p));
        }

        int[] bag = new int[M];
        for (int i = 0; i < M; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }


        Collections.sort(list);

        int j = 0;
        long answer = 0;
        for (int i = 0; i < M; i++) {
            for (; j < N; j++) {
                if (list.get(j).weight > bag[i]) {
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

    private static class Tmp implements Comparable<Tmp> {

        int weight;
        int price;

        public Tmp(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Tmp tmp) {
            return this.weight - tmp.weight;
        }
    }
}
