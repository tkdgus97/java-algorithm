package inflearn.sec5;

import java.util.Scanner;
import java.util.Stack;

/**
 * 쇠 막대기
 */
public class IronStick {
    public static int solution(String str) {
        int result = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length() ; i++) {
            char c = str.charAt(i);
            if (c== '(') {
                stack.push(c);
            } else {
                stack.pop();
                if (str.charAt(i - 1) == '(') {
                    result += stack.size();
                } else {
                    result += 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.next();
        System.out.println(solution(str));
    }
}
