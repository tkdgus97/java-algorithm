package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1018 {

    public void sol() throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        char[][] borad = new char[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < col; j++) {
                borad[i][j] = s.charAt(j);
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= col - 8; j++) {
                int r = sol(i, j, borad);
                if (r < result) {
                    result = r;
                }
            }
        }
        System.out.println(result);
    }


    public static int sol(int startRow, int startCol, char[][] board) {
        char[] d = {'W', 'B'};
        int cnt = 0;
        for (int i = startRow; i < startRow + 8; i++) {
            int k = i % 2 == 0 ? 0 : 1;
            for (int j = startCol; j < startCol + 8; j++) {
                if (board[i][j] != d[k % 2]) {
                    cnt++;
                }
                k++;
            }
        }
        return Math.min(cnt, 64 - cnt);
    }
}
