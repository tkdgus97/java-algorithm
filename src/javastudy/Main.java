package javastudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        String[] r1 = new String[n];
        String[] r2 = new String[n];

        for (int i = 0; i < n; i++) {
            r1[i] = paddingAndBinary(arr1[i]);
        }

        for (int i = 0; i < n; i++) {
            r2[i] = paddingAndBinary(arr2[i]);
        }

        return answer;
    }

    public String paddingAndBinary(int a) {
        StringBuilder result = new StringBuilder();
        while (a != 0) {
            result.append(a % 2);
            a = a / 2;
        }

        if (result.toString().length() < 6) {
            while (result.toString().length() != 6) {
                result.append("0");
            }
            result.reverse();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Main M = new Main();
        M.solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10});
    }
}
