package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class S11047 {
    public void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int price = Integer.parseInt(st.nextToken());
        int cnt = 0;
        Integer[] money = new Integer[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            money[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(money, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            if (price == 0) {
                break;
            }
            if (price < money[i]) {
                continue;
            }
            int v = price / money[i];
            price -= (v * money[i]);
            cnt += v;
        }

        System.out.println(cnt);
    }
}
