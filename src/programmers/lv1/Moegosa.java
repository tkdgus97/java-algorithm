package programmers.lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Moegosa {
    static int[][] W = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
    public int[] solution(int[] answers) {
        ArrayList<Integer> li = new ArrayList<>();
        HashMap<Integer, Integer> hs = new HashMap<>();

        int max = -1;
        for (int i = 0; i < W.length; i++) {
            int cnt = 0;
            for (int j = 0; j < answers.length; j++) {
                if (W[i][j] == answers[j]) {
                    cnt++;
                }
            }
            hs.put(i+1, cnt);
        }
//        for (int v : hs.keySet()) {
//            max = Math.max(max, hs.get(v));
//        }
//
//        li.add(max);
//
//        for (int v : hs.keySet()) {
//            if (hs.get(max) == hs.get(v)) {
//                li.add(v);
//            }
//        }
//
//        Collections.sort(li);

        return li.stream().mapToInt(i -> i).toArray();
    }

}
