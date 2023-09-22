package inflearn;

import java.util.Scanner;

public class Main {
    public int solution(int n, int k, int[] arr) {
        int max = 0, sum = 0;
        for (int i = 0; i < k; i++) {
            max += arr[i];
        }
        sum = max;

        for (int i = k; i < n-k; i++) {
            sum += (arr[i] - arr[i-k]);
            max = Math.max(max, sum);
        }

        return max;
    }



    public static void main(String[] args) {
        Main M = new Main();
        Scanner in=new Scanner(System.in);
        int[] arr1;

        int input1 = in.nextInt();
        int k = in.nextInt();
        arr1 = new int[input1];

        for (int i = 0; i < input1; i++) {
            arr1[i] = in.nextInt();
        }

        System.out.print(M.solution(input1, k, arr1));
    }
}
