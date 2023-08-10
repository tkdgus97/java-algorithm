package inflearn.sec7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Songagi {
    int[] check = new int[10001] ;
    int[] dis = {1, -1, 5};
    Queue<Integer> q = new LinkedList<>();
    public int soulution(int s, int e) {
        int L = 0;
        check[s] = 1;
        q.offer(s);

        while (!q.isEmpty()){
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                for (int j = 0; j < dis.length; j++) {
                    int nx = cur + dis[j];
                    if (nx == e) return L + 1;
                    if (nx > 1 && nx < 10001) {
                        check[nx] = 1;
                        q.offer(nx);
                    }
                }
            }
            L++;
        }

        return 0;
    }

    public static void main(String[] args) {
        Songagi M = new Songagi();
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(M.soulution(s,e));
    }
}
