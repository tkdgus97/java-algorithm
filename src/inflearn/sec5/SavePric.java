package inflearn.sec5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class SavePric {
    public static int solution(int size, int outNum) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <=size ; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            for (int i = 0; i < outNum-1; i++) {
                q.offer(q.poll());
            }
            q.poll();
            if (q.size() == 1) {
                answer = q.poll();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();
        int v = in.nextInt();
        System.out.println(solution(size, v));
    }
}
