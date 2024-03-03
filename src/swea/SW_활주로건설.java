package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_활주로건설 {
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //테스트 케이스 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int test_case = 1; test_case <= t; test_case++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            int result = 0;
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (j == 0) {
                        if (rowSearch(i, N, X)) {
                            result++;
                        }
                    }
                    if (i == 0) {
                        if (colSearch(j, N, X)) {
                            result++;
                        }
                    }

                }
            }

            sb.append("#").append(test_case).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean rowSearch(int i, int N, int x) {
        int cnt = 1;
        int length = map[i][0];

        for (int k = 1; k < N; k++) {
            if (map[i][k] == length) {
                cnt++;
            } else if (length - map[i][k] == 1) { //1 낮을 경우
                if (N - k < x) {
                    return false;
                } else {
                    int tmpCnt = 1;
                    for (int j = k + 1; j < N; j++) {
                        if (map[i][j] != map[i][k] && tmpCnt < x) {
                            return false;
                        }
                        if (tmpCnt == x) {
                            k = j ;
                            break;
                        }
                        tmpCnt++;
                    }
                    length = map[i][k];
                    cnt = 1;
                }
            } else if (length - map[i][k] == -1) {
                if (cnt >= x) {
                    length = map[i][k];
                    cnt = 1;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    private static boolean colSearch(int j, int N, int x) {
        int cnt = 1;
        int len = map[0][j];

        for (int k = 1; k < N; k++) {
            if (map[k][j] == len) {
                cnt++;
            } else if (len - map[k][j] == 1) { //1 높을 경우
                if (N - k < x) {
                    return false;
                } else {
                    int tmpCnt = 1;
                    for (int l = k + 1; l < N; l++) {
                        if (map[l][j] != map[k][j] && tmpCnt < x) {
                            return false;
                        }
                        if (tmpCnt == x) {
                            k = l;
                            break;
                        }
                        tmpCnt++;
                    }
                    len = map[k][j];
                    cnt = 1;
                }
            } else if (len - map[k][j] == -1) {
                if (cnt >= x) {
                    len = map[k][j];
                    cnt = 1;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

}
