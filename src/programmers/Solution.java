package programmers;

import java.util.Stack;

public class Solution {
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

    public static void main(String[] args) {
        Solution M = new Solution();
        System.out.println(M.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
    }

}
