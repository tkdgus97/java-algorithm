package programmers.lv1;

public class SplitString {

    public int solution(String s) {
        int result = 0;
        char now = s.charAt(0);
        //s와 s가 아닌 글자들이 나온 횟수
        int nowV = 0;
        int etcV = 0;

        for (int i = 0; i < s.length(); i++) {
            if (nowV == etcV) {
                result++;
                now = s.charAt(i);
            }
            if (s.charAt(i) == now) {
                nowV++;
            } else {
                etcV++;
            }
        }
        return result;
    }
}
