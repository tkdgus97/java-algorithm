package programmers.lv1;

import java.util.HashMap;

public class RoughlyKeymap {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        HashMap<Character, Integer> map = new HashMap<>();
        for (String s : keymap) {
            for (int j = 0; j < s.length(); j++) {
                int key = map.containsKey(s.charAt(j)) ? Math.min(map.get(s.charAt(j)), j + 1) : j + 1;
                map.put(s.charAt(j), key);
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int cnt = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                if (!map.containsKey(targets[i].charAt(j))) {
                    answer[i] = -1;
                    break;
                }
                cnt += map.get(targets[i].charAt(j));
                if (j == targets[i].length() - 1) {
                    answer[i] = cnt;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        RoughlyKeymap M = new RoughlyKeymap();

        M.solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD","AABB"});
    }
}
