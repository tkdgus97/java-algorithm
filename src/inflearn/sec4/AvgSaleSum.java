package inflearn.sec4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AvgSaleSum {
    public List<Integer> solution(int N, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int lt = 0;

        for (int i = 0; i < N - 1; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i],0) + 1 );
        }

        for (int rt = N - 1; rt < arr.length; rt++) {
            hm.put(arr[rt], hm.getOrDefault(arr[rt],0) + 1);
            answer.add(hm.size());
            hm.put(arr[lt], hm.get(arr[lt]) - 1);
            if (hm.get(arr[lt]) == 0){
                hm.remove(arr[lt]);
            }
            lt++;
        }

        return answer;
    }
}
