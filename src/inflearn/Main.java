package inflearn;

import java.util.Scanner;

public class Main {
    public int solution(int n, int k, int[] arr) {
        int answer = 0, lt = 0, cnt = 0;

        //1 1 0 0 1 1 0 1 0 1 1 0 1 0 1 1 0 0
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) {
                cnt++;
            }
            while (cnt > k) {
                if (arr[lt] == 0) {
                    cnt--;
                }
                lt++;
            }

            answer = Math.max(answer, rt - lt + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.print(M.solution(n, k, arr));
    }
}
