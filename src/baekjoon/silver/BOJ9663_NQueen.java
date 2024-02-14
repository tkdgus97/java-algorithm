package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9663_NQueen {
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        int[] check = new int[N];

        back(0, check, N);
        System.out.println(result);
    }

    private static void back(int L, int[] check, int N) {
        if (L == N) {
            result += 1;
            return;
        }

        for (int i = 0; i < N; i++) {
            check[L] = i;
            if (possible(L, i, check)) {
                back(L + 1, check, N);
            }
        }
    }

    /**
     * @param index - 몇번째인지를 의미
     * @param value - index 값에 들어가는 값
     * @param ch    - 현재 값 상태 배열
     * @return
     */
    private static boolean possible(int index, int value, int[] ch) {
        if (index == 0) {
            return true;
        }

        for (int i = 0; i < index; i++) {
            if (ch[i] == value) {
                return false;
            }
            //대각선 체크
            if (Math.abs(index - i) == Math.abs(ch[index] - ch[i])) {
                return false;
            }
        }
        return true;
    }
}
