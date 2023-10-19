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

    public static void DFS(int x, int y) {
    }
}
