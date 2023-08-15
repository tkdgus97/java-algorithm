package programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Topcoat {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        List<Integer> sec = new ArrayList<>();
        for (int x : section) {
            q.add(x);
        }

        while (!q.isEmpty()) {
            int startNum = q.peek();
            for (int i = 0; i < m; i++) {
                if (startNum == q.peek()) {
                    q.poll();
                }
                if (q.isEmpty()) {
                    answer++;
                    break;
                }
                startNum++;
            }
            if (!q.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }

    public int solution2(int n, int m, int[] section){
        int roller = section[0];
        int cnt = 1;
        for(int i = 1; i < section.length; i++) {
            if(roller + m - 1 < section[i]) {
                cnt++;
                roller = section[i];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Topcoat M = new Topcoat();
        M.solution2(8,4, new int[]{2,3,6});
    }
}
