package ssafy.b.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        //
        int checkAll = (1 << 10) - 1;

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int tmpN = N;
            int checkNow = 0;
            while(true) {
                String toStr = String.valueOf(tmpN);
                for (int i = 0; i < toStr.length(); i++) {
                    int shiftV = (1 << Character.getNumericValue(toStr.charAt(i)));
                    if ((checkNow & shiftV) == 0) {
                        checkNow = (checkNow | shiftV);
                    }
                }

                if ((checkAll & checkNow) == checkAll) {
                    break;
                }
                tmpN += N;
            }
            sb.append("#").append(test_case).append(" ").append(tmpN).append("\n");
        }
        System.out.println(sb);
    }
}
