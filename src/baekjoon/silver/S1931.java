package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class S1931 {
    public void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        ArrayList<Tmp> timeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            timeList.add(
                new Tmp(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(timeList);
        int endTime = timeList.get(0).end;
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (timeList.get(i).start >= endTime) {
                cnt ++;
                endTime = timeList.get(i).end;
            }
        }

        System.out.println(cnt);
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
            if (this.end == tmp.end) {
                return this.start - tmp.start;
            }
            return this.end - tmp.end;
        }
    }
}
