package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2839 {
    public void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int answer = 0;
        while (true) {
            if (N < 0) {
                answer = -1;
                break;
            }
            if (N % 5 == 0) {
                answer += (N / 5);
                break;
            }
            N -= 3;
            answer += 1;
        }
        System.out.println(answer);
    }

}
