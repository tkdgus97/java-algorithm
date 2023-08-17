package programmers.lv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonInfoPeriod {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();

        HashMap<String, Integer> termMap = new HashMap<>();

        for (String t : terms) {
            String[] d = t.split(" ");
            termMap.put(d[0], Integer.valueOf(d[1]));
        }

        int nowDate = getDate(today);

        for (int i = 0; i < privacies.length; i++) {
            String[] sP = privacies[i].split(" ");
            String day = sP[0];

            int termMonth = termMap.get(sP[1]);

            if ((getDate(day) + (termMonth * 28)) <= nowDate) {
                result.add(i);
            }
        }

        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i) + 1;
        }
        return answer;
    }

    private int getDate(String date) {
        String[] sDate = date.split("\\.");
        int[] iDate = new int[3];

        for (int i = 0; i < sDate.length; i++) {
            iDate[i] = Integer.parseInt(sDate[i]);
        }

        return (iDate[0] * 12 * 28) + (iDate[1] * 28) + iDate[2];
    }
}
