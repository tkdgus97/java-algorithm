package baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

public class WordSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = in.next();
        }

        Arrays.sort(arr, (s, t1) -> {
            if (s.length() == t1.length()) {
                return s.compareTo(t1);
            } else {
                return s.length() - t1.length();
            }
        });

        System.out.println(arr[0]);
        for (int i = 1; i < N; i++) {
            if (!arr[i].equals(arr[i-1])) {
                System.out.println(arr[i]);
            }
        }
    }
}
