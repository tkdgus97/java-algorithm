package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class VirusCheck {
    public void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] number = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int tleader = Integer.parseInt(st.nextToken()), tmember = Integer.parseInt(st.nextToken());

        long count = 0;

        for (int i = 0; i < N; i++) {
            int v = number[i];
            if (v - tleader < 0) {
                count += 1;
                continue;
            }
            v = v - tleader;
            count += (v % tmember == 0 ? v / tmember : (v / tmember) + 1) + 1;
        }

        System.out.println(count);
    }
}
