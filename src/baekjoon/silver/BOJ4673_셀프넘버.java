package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4673_셀프넘버 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[] selfCheeck = new boolean[20000];
        for (int i = 1; i < 10000; i++) {
            int nextNum = i + totalSum(i);
            selfCheeck[nextNum] = true;
        }

        for (int i = 1; i < 10000; i++) {
            if (!selfCheeck[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int totalSum(int i) {
        String toS = String.valueOf(i);
        int total = 0;
        for (int j = 0; j < toS.length(); j++) {
            total += Character.getNumericValue(toS.charAt(j));
        }
        return total;
    }
}
