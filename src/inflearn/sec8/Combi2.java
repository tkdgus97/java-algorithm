package inflearn.sec8;

public class Combi2 {
    static int[][] dy;

    public int combi(int n, int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }
        //조합에서 마지막 종착지 조건 r == 0일 경우 1인 이유는 아무것도 뽑지 않는것도 하나의 경우로 판단
        if (n == r || r == 0) {
            return 1;
        } else {
            return dy[n][r] = combi(n-1, r - 1) + combi(n-1, r);
        }
    }

    public static void main(String[] args) {
        Combi2 M = new Combi2();
    }
}
