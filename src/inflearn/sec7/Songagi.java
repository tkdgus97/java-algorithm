package inflearn.sec7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Songagi {
    int[] ch = new int[10001] ;
    int[] dis = {1, -1, 5};
    Queue<Integer> Q = new LinkedList<>();
    public int soulution(int s, int e) {
        ch[s] = 1;
        Q.offer(s);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int x = Q.poll();
                for (int j = 0; j < 3; j++) {
                    int nx = x + dis[j];
                    if (nx == e) {
                        return L;
                    }
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
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
