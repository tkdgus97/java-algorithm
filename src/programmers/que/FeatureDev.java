package programmers.que;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FeatureDev {

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();

        //2.함계 배포할 기능의 index 찾기
        //3.이번에 배포할 기능의 개수 추가
        int point = 0;
        for (int i = 0; i < progresses.length; i++) {
            //1.한번 기능을 개발하는데 필요한 날짜 계산
            int remain = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            int j = i + 1;
            int cnt = 1;
            for (; j < progresses.length; j++) {
                if (progresses[j] + remain * speeds[j] < 100) {
                    break;
                }
            }
            list.add(j - i);
            i = j - 1;
        }

        return list.stream().mapToInt(integer -> integer).toArray();
    }

    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        solution(progresses, speeds);
    }

}
