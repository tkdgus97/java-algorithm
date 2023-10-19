package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B1664 {
    public void sol()  {
        Scanner sc = new Scanner(System.in);
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
}
