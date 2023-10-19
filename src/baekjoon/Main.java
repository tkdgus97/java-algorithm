package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//문제 풀이용
public class Main {
//    static int[] dx = {-1, 1, 0, 0};
//    static int[] dy = {0, 0, -1, 1};
//    static int[][] map;
//    static boolean[][] visit;
//    static int N,M, res, cnt;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        boolean prime[] = new boolean[N + 1];
        List<Integer> p = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            prime[i] = true;
        }

        for(int i=2; i<=N; i++){
            // prime[i]가 소수라면
            if(prime[i]){
                p.add(i);
                // prime[j] 소수가 아닌 표시
                for(int j=i+i; j<=N; j+=i) prime[j] = false;
            }
        }

        int sum = 0, res = 0, lt = 0;
        for (int rt = 0; rt < p.size(); rt++) {
            sum += p.get(rt);
            if (sum == N) {
                res++;
            }
            while (sum >= N) {
                sum -= p.get(lt++);
                if (sum == N) {
                    res++;
                }
            }
        }

        System.out.println(res);

    }

    public static void DFS(int x, int y) {
    }
}
