package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1929 {
    public void main() throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean[] sosu = new boolean[end + 1];
        sosu[0] = sosu[1] = true;

        for (int i = 2; i <= end; i++) {
            if (!sosu[i]) {
                for (int j = i + i; j <= end; j += i) {
                    sosu[j] = true;
                }
            }
        }

        for (int i = start; i <= end; i++) {
            if (!sosu[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
