package inflearn.sec3;

public class MaxLenSequence {
    public int solution(int n, int k, int[] arr) {
        int answer = 0, lt = 0, cnt = 0;

        //1 1 0 0 1 1 0 1 0 1 1 0 1 0 1 1 0 0
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) {
                cnt++;
            }
            while (cnt > k) {
                if (arr[lt] == 0) {
                    cnt--;
                }
                lt++;
            }

            answer = Math.max(answer, rt - lt + 1);
        }

        return answer;
    }
}
