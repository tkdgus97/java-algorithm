package inflearn.sec5;

import java.util.Scanner;
import java.util.Stack;

/**
 * 후위식 연산
 */
public class Postfix {
    public int solution(String str) {
        //스택 선언
        Stack<Integer> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {
                stack.push(Character.getNumericValue(x));
            } else {
                int rVal = stack.pop();
                int lVal = stack.pop();

                stack.push(this.cal(x, lVal, rVal));
            }
        }

        return stack.pop();
    }

    private int cal(char sign, int lVal, int rVal) {
        int result = 0;
        switch (sign) {
            case '+':
                result = lVal + rVal;
                break;
            case '-':
                result = lVal - rVal;
                break;
            case '*':
                result = lVal * rVal;
                break;
            case '/':
                result = lVal / rVal;
                break;
            default:
                throw new IllegalArgumentException();
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.next();

        Postfix p = new Postfix();

        System.out.println(p.solution(str));
    }
}
