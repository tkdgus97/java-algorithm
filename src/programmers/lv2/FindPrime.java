package programmers.lv2;

import java.util.HashSet;

public class FindPrime {
    HashSet<Integer> hs = new HashSet<>();
    static int[] ch;
    static char[] arr;

    public void DFS(String s, int N) {
        if (!s.equals("")) {
            if (isPrime(Integer.valueOf(s))) {
                hs.add(Integer.valueOf(s));
            }
        }
        if (N == arr.length) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (ch[i] == 1) continue;
            ch[i] = 1;
            DFS(s + arr[i], N + 1);
            ch[i] = 0;
        }
    }

    public int solution(String numbers) {
        int answer = 0;
        ch = new int[numbers.length()];
        arr = numbers.toCharArray();

        DFS("", 0);
        return hs.size();
    }

    public boolean isPrime(int n) {
        if (n == 1 || n == 0) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
