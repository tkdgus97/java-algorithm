package inflearn.sec7;

public class Fibonacci {
    static int[] fibo;
    public int DFS(int n) {
        if (fibo[n] > 0) return fibo[n];
        if (n == 1 || n == 2) {
            return fibo[n] = 1;
        }
        else {
            return fibo[n] = DFS(n-1) + DFS(n - 2);
        }
    }

    public static void main(String[] args) {
        Fibonacci F = new Fibonacci();
        int n = 45;
        fibo = new int[n+1];
        F.DFS(n);
        for (int i = 1; i < n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }
}
