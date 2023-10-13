package baekjoon.silver;

import java.util.Scanner;

public class NubersSum1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        int a = 1;
        while (true) {
            if (n >= a) n -= a++;
            else break;
        }

        System.out.println(--a);
    }
}
