package baekjoon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//문제 풀이용
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String V = sc.next();
            String[] vs = V.split(" ");
            if (vs[1].equals("enter")) {
                set.add(vs[0]);
            } else if(vs[1].equals("leave")) {
                set.remove(vs[0]);
            }
        }

        for (String s : set) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

}
