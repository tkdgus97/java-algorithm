package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};

        HashMap<String, Set<String>> map = new HashMap<>();
        HashMap<String, Integer> cnt = new HashMap<>();

        for (String v : id_list) {
            map.put(v, new HashSet<>());
        }

        for (String s : report) {
            String[] re = s.split(" ");
            map.get(re[0]).add(re[1]);
        }

        for (String s : id_list) {
            Set<String> tmp = map.get(s);
            for (String name : tmp) {
                cnt.put(name, cnt.getOrDefault(name, 0) + 1) ;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution M = new Solution();
        M.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2);
    }

}
