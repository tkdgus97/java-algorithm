package inflearn.sec7;

public class Subset {
    static int n;
    static int[] subset;

    public void subsetDFS(int L) {
        if (L == n + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < subset.length; i++) {
                if (subset[i] == 1) {
                    sb.append(i+ " ");
                }
            }
            if (sb.length() > 0) {
                System.out.println(sb.toString());
            }
        } else {
            subset[L] = 1;
            subsetDFS(L+1);
            subset[L] = 0;
            subsetDFS(L+1);
        }
    }

    public static void main(String[] args) {
        Subset M = new Subset();
        n = 3;
        subset = new int[n + 1];

        M.subsetDFS(1);
    }
}
