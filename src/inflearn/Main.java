package inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public String solution(String a, String b) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (Character c : a.toCharArray()) {
            int cnt = map.getOrDefault(c , 0);
            map.put(c, cnt + 1);
        }

        for (Character c : b.toCharArray()) {
            int cnt = map.getOrDefault(c, 0);
            map.put(c, cnt - 1);
        }

        for (Character c : map.keySet()) {
            if (map.get(c) != 0) {
                return "NO";
            }
        }

        return "YES";
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner in = new Scanner(System.in);

//        int n = in.nextInt();
        String a = in.next();
        String b = in.next();

        System.out.print(M.solution(a,b));
    }
}
