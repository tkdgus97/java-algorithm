package inflearn.sec7;

import inflearn.Main;

public class BinaryNm {
    public void DFS(int n) {
        if (n == 0) return;
        else {
            DFS(n / 2);
            System.out.print(n % 2);
        }
    }

    public static void main(String[] args) {
        BinaryNm M = new BinaryNm();
        M.DFS(11);
    }
}
