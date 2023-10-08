package inflearn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public List<Integer> solution(int N, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int lt = 0;

        for (int i = 0; i < N - 1; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i],0) + 1 );
        }

        for (int rt = N - 1; rt < arr.length; rt++) {
            hm.put(arr[rt], hm.getOrDefault(arr[rt],0) + 1);
            answer.add(hm.size());
            hm.put(arr[lt], hm.get(arr[lt]) - 1);
            if (hm.get(arr[lt]) == 0){
                hm.remove(arr[lt]);
            }
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        int N = in.nextInt();

        int[] arr = new int[T];

        for (int i = 0; i < T; i++) {
            arr[i] = in.nextInt();
        }

        for (int v : M.solution(N, arr))  {
            System.out.print(v + " ");
        }
    }
}
