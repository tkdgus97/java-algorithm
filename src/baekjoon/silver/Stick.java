package baekjoon.silver;

import java.util.Scanner;

public class Stick {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int stick = 64;
        int cnt = 0;

        int X = sc.nextInt();
        while (X > 0) {
            if (stick > X) {
                stick /= 2;
            } else {
                X -= stick;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
