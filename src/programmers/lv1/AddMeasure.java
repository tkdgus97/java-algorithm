package programmers.lv1;

public class AddMeasure {
    public int solution(int left, int right) {
        int answer = 0;
        int[] cnt = new int[right - left + 1];
        int sNum = left;

        for (int i = 0; i < cnt.length; i++) {
            int num = 0;
            for (int j = 1; j <= sNum; j++) {
                if (sNum % j == 0) {
                    num++;
                }
            }
            cnt[i] = num;
            sNum++;
        }
        sNum = left;
        for (int j : cnt) {
            if (j % 2 == 0) {
                answer += sNum;
            } else {
                answer -= sNum;
            }
            sNum++;
        }

        return answer;
    }

    public static void main(String[] args) {
        AddMeasure M = new AddMeasure();
        M.solution(13,17);
    }
}
