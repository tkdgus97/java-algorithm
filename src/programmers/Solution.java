package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();

        int[] xCnt = new int[10];
        int[] yCnt = new int[10];

        StringBuilder xSb = new StringBuilder(X);
        StringBuilder ySb = new StringBuilder(Y);

        List<Integer> common = new ArrayList<>();

        for (int i = 0; i < xSb.length(); i++) {
            for (int j = 0; j < ySb.length(); j++) {
                if (xSb.charAt(i) == ySb.charAt(j)) {
                    common.add(Character.getNumericValue(xSb.charAt(i)));
                    ySb.deleteCharAt(j);
                }
            }
        }
        if (common.size() == 0) {
            return "-1";
        }

        common.sort(Collections.reverseOrder());

        if (common.get(0) == 0) {
            return "0";
        }

        common.forEach(answer::append);

        return answer.toString();
    }

    public static void main(String[] args) {
        Solution M = new Solution();
        M.solution("12321", "42531");

        System.out.println(M.solution("12321", "42531"));
    }

}
