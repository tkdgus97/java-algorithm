package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class D2005 {
    public void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
//
//        N = Integer.parseInt(st.nextToken());
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int size = sc.nextInt();

            int[][] arr = new int[size + 1][size + 1];
            arr[1][1] = 1;

            for (int j = 2; j <= size; j++) {
                for (int k = 1; k <= j; k++) {
                    arr[j][k] = arr[j - 1][k - 1] + arr[j - 1][k];
                }
            }

            sb.append("#").append(i).append("\n");
            for (int j = 1; j <= size; j++) {
                for (int k = 1; k <= j; k++) {
                    sb.append(arr[j][k]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
