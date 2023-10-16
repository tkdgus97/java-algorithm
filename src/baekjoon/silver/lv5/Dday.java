package baekjoon.silver.lv5;

import baekjoon.Main;
import java.util.Scanner;

public class Dday {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int[] v = new int[6];
        for (int i = 0; i < 6; i++) {
            v[i] = sc.nextInt();
        }
        int c1 = calYear(v[0], v[1], v[2]);
        int c2 = calYear(v[3], v[4], v[5]);

        if (v[3] - v[0] > 1000 || v[3] - v[0] == 1000 && (v[4] > v[1] || v[4] == v[1] && v[2] <= v[5])) {
            System.out.println("gg");
        } else {
            System.out.println("D-" + (c2-c1));
        }
    }

    public static int calYear(int y, int m, int d) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = 0;

        for (int i = 1; i < y; i++) {
            day += 365 + checkYun(i);
        }

        for (int i = 1; i < m; i++) {
            if (i == 2) {
                day += checkYun(y);
            }
            day += days[i];
        }

        return day + d;
    }

    public static int checkYun(int y) {
        if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
