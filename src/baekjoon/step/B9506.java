package baekjoon.step;

import java.util.ArrayList;
import java.util.Scanner;

public class B9506 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> dList = new ArrayList<>();

        while (true) {
            int n1 = sc.nextInt();

            if (n1 == -1) {
                break;
            }
            dList.add(n1);
        }

        for (int num : dList) {
            int sum = 0;
            ArrayList<Integer> arr1 = new ArrayList();

            for (int i = 1; i < num; i++) {
                if (num % i == 0) {
                    arr1.add(i);
                }
            }

            for (int i = 0; i < arr1.size(); i++) {
                int v = arr1.get(i);
                sum += v;
                sb.append(i == arr1.size() - 1 ? v : v + " + ");
            }
            System.out.println(sum == num ? num + " = " + sb : num + " is NOT perfect.");
            sb.setLength(0);
        }
    }
}
