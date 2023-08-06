package inflearn;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public int solution(String s, int N) {
        int answer = 0;

        char[] arr = s.toCharArray();

        Set<Integer> set = new LinkedHashSet<>();

        for (int i = 0; i < s.length() - N +1; i++) {
            if (Character.getNumericValue(arr[i]) <= N) {
                for (int j = i; j < i + N; j++) {
                    if (Character.getNumericValue(arr[j]) <= N) {
                        set.add(Character.getNumericValue(arr[j]));
                    }
                }
                if (set.size() == N) {
                    StringBuilder sb = new StringBuilder();
                    for (int t : set) {
                        sb.append(t);
                    }
                    if (Integer.parseInt(sb.toString()) > answer) {
                        answer = Integer.parseInt(sb.toString());
                    }
                }
            }
            set.clear();
        }
        return answer != 0 ? answer : -1;
    }

    public static void main(String[] args) {
        Main M = new Main();

        System.out.println(M.solution("313253123", 3));
    }
}
