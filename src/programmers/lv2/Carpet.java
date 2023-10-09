package programmers.lv2;

import java.util.ArrayList;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int total = brown + yellow;

        for (int i = 3; i <= total; i++) {
            if (total % i == 0) {
                int w = total / i;
                if (yellow == (i - 2) * (w - 2)) {
                    answer[0] = i;
                    answer[1] = w;
                }
            }
        }

        return answer;
    }
}
