package baekjoon.gold;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G11000 {
    public void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Tmp> list = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();


        for(
            int i = 0;
            i<N;i++)

        {
            st = new StringTokenizer(br.readLine());
            list.add(new Tmp(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);
        pq.offer(list.get(0).end);

        for(
            int i = 1;
            i<N;i++)

        {
            if (pq.peek() <= list.get(i).start) {
                pq.poll();
            }
            pq.offer(list.get(i).end);
        }

        System.out.println(pq.size());
    }

    private static class Tmp implements Comparable<Tmp> {

        int start;
        int end;

        public Tmp(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Tmp tmp) {
            if (this.start == tmp.start) {
                return this.end - tmp.end;
            }
            return this.start - tmp.start;
        }
    }
}
