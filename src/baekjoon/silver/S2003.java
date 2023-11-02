package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2003 {
    public void sol() throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        int find = Integer.parseInt(st.nextToken());

        int[] arr = new int[len];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0, sum = 0, cnt = 0;
        for (int rt = 0; rt < len; rt++) {
            sum += arr[rt];
            if (sum == find) {
                cnt++;
            }
            while(sum >= find) {
                sum -= arr[lt];
                lt++;
                if (sum == find) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
