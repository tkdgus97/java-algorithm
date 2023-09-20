package programmers.lv1;

import java.util.Stack;

public class MakeHamburg {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int x : ingredient) {
            stack.push(x);
            int size = stack.size();
            if (stack.size() >= 4) {
                if (stack.get(size - 4) == 1
                    && stack.get(size - 3) == 2
                    && stack.get(size - 2) == 3
                    && stack.get(size - 1) == 1) {
                    answer++;
                    for (int i = 0; i < 4; i++) {
                        stack.pop();
                    }
                }
            }
        }
        return answer;
    }

}
