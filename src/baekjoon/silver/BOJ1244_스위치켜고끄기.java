package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1244_스위치켜고끄기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int S = Integer.parseInt(st.nextToken());
        int[] switches = new int[S + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= S; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int persons = Integer.parseInt(st.nextToken());

        for (int i = 0; i < persons; i++) {
            st = new StringTokenizer(br.readLine());
            int gen = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            if (gen == 1) { //남자일 경우
                for (int j = target; j <= S; j += target) {
                    switches[j] ^= 1;
                }
            } else {  //여자일 경우
                int lt = target - 1, rt = target + 1;
                while((lt > 0) && (rt <= S)) {
                    if (switches[lt] == switches[rt]) {
                        lt -= 1;
                        rt += 1;
                    } else {
                        break;
                    }
                }

                for (int j = lt + 1; j <=rt - 1; j++) {
                    switches[j] ^= 1;
                }
            }
        }

        for (int i = 1; i <= S; i++) {
            sb.append(switches[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
