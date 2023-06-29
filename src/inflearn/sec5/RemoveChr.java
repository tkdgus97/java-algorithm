package inflearn.sec5;

import java.util.Scanner;
import java.util.Stack;

public class RemoveChr {
    public static String solution(String str) {
        String result = "YES";
        //스택 선언
        Stack<Character> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            //해당 문자일 경우 스택에 push
            if (x == '(') stack.push(x);
            else {
                // ) 해당 문자일 때 스택이 비어있다면 이미 잘못된 문자
                if (stack.isEmpty()) return "NO";
                //스택에서 '(' 문자 pop
                stack.pop();
            }
        }
        //for문이 다 돌았는데 스택이 비어있지 않은 case
        //()()( <- 이런 케이스들이라고 볼 수 있다.즉 앞에는 정상적으로 쌍을 이루었지만 마지막이 달라서 틀린 경우이다.
        if (!stack.isEmpty()) return "NO";

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();
        String[] strArr = new String[size];

        for (int i = 0; i < size; i++) {
            strArr[i] = in.next();
        }

        for (int i = 0; i < size; i++) {
            System.out.println(solution(strArr[i]));
        }
    }
}
