package baekjoon.bronze;

import java.util.Scanner;

public class TruckParking {
    public void solution() {
        Scanner sc = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] price = new int[4];
        int[][] arr = new int[3][2];

        for (int i = 1; i < 4; i++) {
            price[i] = sc.nextInt();
        }

        int minS = Integer.MAX_VALUE;
        int maxS = Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            minS = Math.min(s, minS);
            maxS = Math.max(maxS, e);
            arr[i][0] = s;
            arr[i][1] = e;
        }
        int sum = 0;

        for (int i = minS; i < maxS; i++) {
            int cnt = 0;
            for (int j = 0; j < 3; j++) {
                if (arr[j][0] <= i && arr[j][1] > i) {
                    cnt++;
                }
            }
            sum += price[cnt]*cnt;
        }
        System.out.println(sum);
    }
}
