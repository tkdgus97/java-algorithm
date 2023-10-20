package inflearn.sec9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MeetingBatch {
    static class Ti implements Comparable<Ti>{
        int s;
        int e;

        public Ti(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Ti ti) {
            if (ti.e == this.e) {
                return this.s - ti.s;
            }
            return this.e - ti.e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Ti> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Ti(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        int et = 0, cnt = 0;
        for (Ti t : list) {
            if (t.s >= et) {
                cnt++;
                et = t.e;
            }
        }
        System.out.println(cnt);
    }
}
