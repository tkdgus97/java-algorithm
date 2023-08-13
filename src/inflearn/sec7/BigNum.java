package inflearn.sec7;

import java.util.Arrays;

public class BigNum {

    public String solution(int[] numbers) {
        String answer = "0";
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(numbers[i]);
            for (int j = 0; j < numbers.length; j++) {
                if (j != i) {
                    sb.append(numbers[j]);
                }
            }
            if (Integer.parseInt(answer) < Integer.parseInt(sb.toString())) {
                answer = sb.toString();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        BigNum M = new BigNum();
        System.out.println(M.solution(new int[]{3, 30, 34, 5, 9}));
    }
}
