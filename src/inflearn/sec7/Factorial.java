package inflearn.sec7;

public class Factorial {
    public int DFS(int n) {
        if (n == 1) return 1;
        else return n*DFS(n-1);
    }

    public static void main(String[] args) {
        Factorial F = new Factorial();
        System.out.println(F.DFS(5));

    }
}
