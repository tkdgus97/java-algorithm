package programmers.lv1;

import java.util.HashSet;
import java.util.Set;

public class TwoEnc {
    public String solution(String s, String skip, int index) {
        StringBuilder answer= new StringBuilder();
        char[] sArr = s.toCharArray();

        Set<Character> pArr = new HashSet<>();
        for (char c: skip.toCharArray()) {
            pArr.add(c);
        }

        for (char c : sArr) {
            char start = c;

            for (int j = 0; j < index; j++) {
                start++;
                if (start > 122) {
                    start = 'a';
                }
                if (pArr.contains(start)) {
                    j--;
                }
            }
            answer.append(start);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        TwoEnc M = new TwoEnc();

        M.solution("aukks", "wbqd", 5);
    }
}
