package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1463 {
    static Integer[] dp;
    public void main() throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        dp = new Integer[num+1];
        dp[0] = dp[1] = 0;
        System.out.println(cur(num));
    }

    public static int cur(int n) {
        if (dp[n] == null) {
            if (n % 6 == 0) {
                dp[n] = Math.min(cur(n / 3), Math.min(cur(n / 2), cur(n - 1))) + 1;
            } else if (n % 3 == 0) {
                dp[n] = Math.min(cur(n / 3), cur(n - 1)) + 1;
            } else if (n % 2 == 0) {
                dp[n] = Math.min(cur(n / 2), cur(n - 1)) + 1;
            } else {
                dp[n] = cur(n -1) + 1;
            }
        }
        return dp[n];
    }
}
