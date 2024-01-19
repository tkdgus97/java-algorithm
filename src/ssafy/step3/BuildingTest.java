package ssafy.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BuildingTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }
        //dy = 상하값 조회 시
        //dx = 좌우값 조회 시
        int[] dx = {0,0,-1,1,-1,1,1,-1};
        int[] dy = {1,-1,0,0,-1,-1,1,1};

        int max = Integer.MIN_VALUE;
        //세로(열) 탐색
        for (int i = 0; i < N; i++) {
            //가로(행) 탐색
            for (int j = 0; j < N; j++) {
                //빌딩일 경우
                if (map[i][j] == 'B') {
                    //빌딩 시작값
                    int sum = 0;
                    boolean flag = true;
                    for (int k = 0; k < 8; k++) {
                        int nx = dx[k] + j, ny = dy[k] + i;
                        if ((nx >= 0 && nx < N) && (ny >= 0 && ny < N)) {
                            if (map[nx][ny] == 'G') {
                                flag = false;
                                break;
                            }
                        }
                    }
                    if (flag) {
                        for (int k = 0; k < N; k++) {
                            if (map[i][k] == 'B') {
                                sum++;
                            }
                            if (map[k][j] == 'B') {
                                sum++;
                            }
                        }
                        max = Math.max(max, sum - 1);
                    } else {
                        sum = 2;
                        max = Math.max(max, sum);
                    }
                }
            }
        }

        System.out.println(max);
    }
}
