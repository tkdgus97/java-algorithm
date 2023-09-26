package inflearn.sec4;

import java.util.HashMap;

public class AnaGram {
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
}
