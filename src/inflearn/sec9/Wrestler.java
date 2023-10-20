package inflearn.sec9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Wrestler {

    static class Man implements Comparable<Man> {
        int h;
        int w;

        public Man(int h, int w) {
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Man m) {
            return m.h - this.h;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        ArrayList<Man> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            list.add(new Man(h, w));
        }

        Collections.sort(list);

        int max = Integer.MIN_VALUE, cnt = 0;
        for (Man m : list) {
            if (max < m.w) {
                max = Math.max(max, m.w);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
