package programmers.lv1;

import java.util.HashMap;

public class MemoryScore {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        //photo 길이만큼 선언
        int[] answer = new int[photo.length];

        HashMap<String, Integer> hash = new HashMap<>();

        //각 사람 별 그리움 점수 저장
        for (int i = 0; i < name.length; i++) {
            hash.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (int j = 0; j < photo[i].length; j++) {
                //hash에서 값 조회 시 없으면 0을 반환 -> 그리움 점수가 없는 사람 0점 처리
                sum += hash.getOrDefault(photo[i][j], 0);
            }
            answer[i] = sum;
        }

        return answer;
    }

}
