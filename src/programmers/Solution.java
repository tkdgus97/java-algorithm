package programmers;

import java.util.ArrayList;

public class Solution {

    static int[][] W = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

    public int[] solution(int[] answers) {
        ArrayList<Integer> li = new ArrayList<>();
        int[] cnt = new int[3];

        for (int i = 0; i < W.length; i++) {
            for (int j = 0; j < answers.length; j++) {
                if (W[i][j % W[i].length] == answers[j]) {
                    cnt[i]++;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (max < cnt[i]) {
                max = cnt[i];
            }
        }

        for (int i = 0; i < 3; i++) {
            if (max == cnt[i]) {
                li.add(i + 1);
            }
        }

        return li.stream().mapToInt(i -> i).toArray();
    }

}
