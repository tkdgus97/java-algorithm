package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2164 {
    public void sol() throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 1; i <= num; i++) {
            Q.add(i);
        }
        while(Q.size() > 1) {
            Q.poll();
            int v = Q.poll();
            Q.add(v);
        }
        System.out.println(Q.poll());
    }
}
