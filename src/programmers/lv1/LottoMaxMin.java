package programmers.lv1;

import java.util.HashSet;

public class LottoMaxMin {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int eqNumCnt = 0;
        int zeroCnt = 0;
        HashSet<Integer> win = new HashSet<>();

        for (int v : win_nums) {
            win.add(v);
        }

        for (int v : lottos) {
            if (v == 0) {
                zeroCnt++;
            }
            if (win.contains(v)) {
                eqNumCnt++;
            }
        }

        answer[0] = eqNumCnt + zeroCnt > 1 ? 7 - (eqNumCnt + zeroCnt) : 6;
        answer[1] = eqNumCnt > 1 ? 7 - eqNumCnt : 6;
        return answer;
    }

    public static void main(String[] args) {
        LottoMaxMin M = new LottoMaxMin();
        for (int x : M.solution(new int[]{44, 1, 0, 0, 31, 25},new int[]{31, 10, 45, 1, 6, 19})) {
            System.out.println("x = " + x);
        }
    }
}
