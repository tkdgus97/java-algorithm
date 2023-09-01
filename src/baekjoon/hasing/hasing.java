package baekjoon.hasing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class hasing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String v = sc.next();
            String[] sv = v.split(" ");
            if (sv[1].equals("enter")) {
                list.add(sv[0]);
            } else {
                list.remove(sv[0]);
            }
        }

        list.sort(Comparator.reverseOrder());

        for (String s : list) {
            sb.append(s).append("/n");
        }
        System.out.println(sb);
    }
}
