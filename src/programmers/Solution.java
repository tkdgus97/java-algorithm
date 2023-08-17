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

        }



        return answer;
    }

    public static void main(String[] args) {
        Solution M = new Solution();
    }

}
