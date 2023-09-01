package baekjoon.step;

import baekjoon.Main;
import java.util.Scanner;

public class B1978 {

    static int[] ch;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int len = sc.nextInt();

        ch = new int[len];

        for (int i = 0; i < len; i++) {
            ch[i] = sc.nextInt();
        }
        
        for (int v : ch) {
            //1인 이유는 1을 소수로 가지기 때문 0부터 시작해서 밑에 조건을 1로 해도됨
            int cnt = 1;

            //입력값이 0 또는 1 일 경우 continue
            if (v == 0 || v == 1) {
                continue;
            }

            //2부터 시작해서 v값 이하까지의 수 중 약수인지 확인
            for (int i = 2; i <= v; i++) {
                if (v % i == 0) {
                    cnt++;
                }
            }

            //cnt가 2개라면 해당 수는 1과 자기 자신을 가지기 때문에 소수이다.
            if (cnt == 2) {
                result++;
            }
        }

        System.out.println(result);
    }

}
