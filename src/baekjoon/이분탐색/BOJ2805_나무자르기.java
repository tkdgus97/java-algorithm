package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2805_나무자르기 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //나무의 수
        int N = Integer.parseInt(st.nextToken());
        //원하는 길이
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int min = 0;
        int mid = 0;

        while (min < max) {
            mid = (min + max) / 2;
            long len = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] - mid > 0) {
                    len += arr[i] - mid;
                }
            }

            /**
             * 합친 길이가 원하는 길이보다 작다
             * 자르고자 하는 높이를 높여야 낮춰야 한다
             * 다시 말해 MAX 값을 낮춰라
             */
            if (len < M) {
                max = mid;
            }
            /**
             * 합친 길이가 원하는 길이보다 크다
             * 기준 높이를 높여야 한다.
             * 다시 말해 MIN 값을 높여라
             */
            else {
                //기존의 mid 값은 확인을 했기 때문에 +1
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}
