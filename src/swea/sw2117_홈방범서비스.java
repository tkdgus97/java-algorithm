package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class sw2117_홈방범서비스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //테스트 케이스 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int test_case = 1; test_case <= t; test_case++) {
            //-------------- 입력 --------------
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            List<int[]> homes = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    if (Integer.parseInt(st.nextToken()) == 1) {
                        homes.add(new int[]{i, j});
                    }
                }
            }

            int result = check(M, N, homes);
            //-------------- 입력 --------------
            sb.append("#").append(test_case).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static int check(int M, int N, List<int[]> homes) {
        int K = 1;
        int result = 0;
        while (K <= N + 1) {
            int defaultPrice =  K * K + ((K - 1) * (K - 1));
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int homeCnt = 0;
                    for (int[] home : homes) {
                        if (Math.abs(i - home[0]) + Math.abs(j - home[1]) <= K - 1) {
                            homeCnt++;
                        }
                    }
                    int price = (M * homeCnt) - defaultPrice;

                    if (price >= 0) {
                        if (result < homeCnt) {
                            result = homeCnt;
                        }
                    }
                }
            }
            K++;
        }
        return result;
    }
}
