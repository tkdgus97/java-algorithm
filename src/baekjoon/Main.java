package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//문제 풀이용
public class Main {

    //    static int[] dx = {-1, 1, 0, 0};
//    static int[] dy = {0, 0, -1, 1};
//    static int[][] map;
//    static boolean[][] visit;
//    static int N,M, res, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력을 받는다.
        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = stod(br.readLine());
        }

        // 2. double max = arr[0];으로 선언한다.
        double max = arr[0];

        // 3. for i -> 1 to n까지 반복하면서,
        for (int i = 1; i < n; i++) {
            // arr[i-1]*arr[i]가 arr[i]보다 크다면, arr[i]를 갱신한다.
            arr[i] = Math.max(arr[i], arr[i - 1] * arr[i]);
            // 4. arr[i]가 max값보다 크다면 max를 갱신한다.
            max = Math.max(max, arr[i]);
        }
        // 5. max를 출력한다.
        System.out.printf("%.3f", max);
    }

    public static double stod(String str) {
        return Double.parseDouble(str);
    }

    public static void DFS(int x, int y) {
    }
}
