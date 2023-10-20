package inflearn.sec9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Wedding {
    static class Test implements Comparable<Test> {
        int time;
        char state;

        public Test(int time, char state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Test test) {
            if (this.time == test.time) {
                return this.state - test.state;
            }
            
            return this.time - test.time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Test> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Test(s, 's'));
            list.add(new Test(e, 'e'));
        }

        Collections.sort(list);
        int cnt = 0;
        int answer = 0;
        for (Test t : list) {
            if (t.state == 'e') {
                cnt--;
            } else {
                cnt++;
            }
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }
}
