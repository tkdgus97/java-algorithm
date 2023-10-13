package baekjoon.silver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Josephus {
    public static String sol(int n, int k) {
        Queue<Integer> Q = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for (int i = 1; i <= n; i++) Q.add(i);
        while (Q.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                Q.offer(Q.poll());
            }
            answer.add(Q.poll());
        }

        for (int x : answer) {
            sb.append(x).append(", ");
        }
        sb.append(Q.poll()).append(">");
        return sb.toString();
    }
}
