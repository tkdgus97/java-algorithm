package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1475_방번호 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();

        int[] count = new int[10];

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N.length(); i++) {
            int number = Character.getNumericValue(N.charAt(i));
            if (number == 6) {
                if (count[6] > count[9]) {
                    count[9] += 1;
                } else {
                    count[6] += 1;
                }
            } else if (number == 9) {
                if (count[9] > count[6]) {
                    count[6] += 1;
                } else {
                    count[9] += 1;
                }
            } else {
                count[number] += 1;
            }
            if (result < count[number]) {
                result = count[number];
            }
        }
        System.out.println(result);
    }
}
