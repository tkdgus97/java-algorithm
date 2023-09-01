package inflearn.sec8;

public class Combi {
    static int[][] arr;

    //nCr = n 개중에서 r 개를 뽑는 것을 의미 nCr = n-1Cr-1 + n-1Cr
    public int DFS(int n, int r){
        if (arr[n][r] > 0) {
            return arr[n][r];
        }
        //조합에서 마지막 종착지 조건 r == 0일 경우 1인 이유는 아무것도 뽑지 않는것도 하나의 경우로 판단
        if (n == r || r == 0) {
            return 1;
        } else {
            return arr[n][r] = DFS(n-1, r - 1) + DFS(n-1, r);
        }
    }

    public static void main(String[] args) {
        Combi M = new Combi();
        arr = new int[11][11];
        M.DFS(10,6);
    }
}
