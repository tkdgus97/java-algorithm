package baekjoon.silver;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class S3273 {
    public void sol() {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int X = sc.nextInt();
        int cnt = 0;
        Arrays.sort(arr);

        int st = 0, en = N -1;
        int sum = 0;
        while (st < en) {
            sum = arr[st] + arr[en];
            if (sum == X) {
                cnt++;
            }
            //합한 값이 X보다 작거나 같다면 start++

            if (sum <= X) st++;
            else en--;
        }
        System.out.println(cnt);
    }
}
