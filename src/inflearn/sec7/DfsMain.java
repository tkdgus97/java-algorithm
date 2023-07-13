package inflearn.sec7;

/**
 * 피보나치 수열
 */
public class DfsMain {

    private static int[] fibo;
    public int DFS(int n) {
        if (fibo[n] > 0) {
            return fibo[n];
        }
        if (n ==1 || n == 2) {
            return fibo[n] = 1;
        } else {
            return fibo[n] = DFS(n-2) + DFS(n-1);
        }
    }

    public static void main(String[] args) {
        DfsMain D = new DfsMain();
        fibo = new int[41];
        D.DFS(40);
        for (Integer v : fibo) {
            System.out.print(v + " ");
        }
    }
}
