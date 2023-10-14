package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//문제 풀이용
public class Main {

//    public static String sol(int n, int k) {
//        return null;
//    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i <= s.length() - 2; i++) {
            for (int j = i + 1; j <= s.length() - 1; j++) {
                StringBuilder s1 = new StringBuilder(s.substring(0, i));
                StringBuilder s2 = new StringBuilder(s.substring(i, j));
                StringBuilder s3 = new StringBuilder(s.substring(j, s.length()));

                String tmp = s1.reverse().append(s2.reverse()).append(s3.reverse()).toString();

                list.add(tmp);
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0));
    }


}
