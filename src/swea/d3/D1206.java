package swea.d3;

import java.util.Scanner;

public class D1206 {
    static char[] arr;
    static int max, count;

    public void sol() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            arr = sc.next().toCharArray();
            count = sc.nextInt();

            max = 0;
            if(arr.length < count) {	// swap 횟수가 자릿수보다 클 때
                count = arr.length;	// 자릿수만큼만 옮겨도 전부 옮길 수 있음
            }
            dfs(0, 0);

            sb.append("#").append(test_case).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int start, int cnt) {
        if (cnt == count) {
            StringBuilder sb = new StringBuilder();
            for (char c : arr) {
                sb.append(c);
            }
            max = Math.max(max, Integer.parseInt(sb.toString()));
            return;
            //횟수 전부 소진 시
        }
        for (int i = start; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                char tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                dfs(i, cnt + 1);
                tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }
    }
}
