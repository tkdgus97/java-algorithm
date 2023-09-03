package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, Set<String>> map = new HashMap<>();
        HashMap<String, Integer> cnt = new HashMap<>();

        for (String v : id_list) {
            map.put(v, new HashSet<>());
            cnt.put(v, 0);
        }

        for (String s : report) {
            String[] re = s.split(" ");
            map.get(re[0]).add(re[1]);
        }

        for (String s : id_list) {
            for (String name : map.get(s)) {
                cnt.put(name, cnt.getOrDefault(name, 0) + 1) ;
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            for (String name :map.get(id_list[i])) {
                if (cnt.get(name) >= k) {
                    answer[i]++;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution M = new Solution();
        M.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2);
    }

}
