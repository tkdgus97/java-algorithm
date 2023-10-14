package baekjoon.silver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoodinateSort {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            list.add(new Point(x, y));
        }

        list.sort((o1, o2) -> {
            if (o1.x == o2.x) return o1.y - o2.y;
            else return o1.x - o2.x;
        });

        for (Point p : list) {
            System.out.println(p.x + " " + p.y);
        }
    }
}
