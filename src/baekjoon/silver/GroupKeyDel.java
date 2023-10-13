package baekjoon.silver;

import java.util.HashSet;

public class GroupKeyDel {
    public static int sol(String[] arr) {
        int cnt = 0;
        for (String s : arr) {
            char[] c = s.toCharArray();
            if (c.length == 1) {
                cnt++;
                continue;
            }
            HashSet<Character> hs = new HashSet<>();

            hs.add(c[0]);
            for (int i = 1; i < c.length; i++) {
                if (c[i - 1] != c[i]) {
                    if (!hs.contains(c[i])) {
                        hs.add(c[i]);
                    } else break;
                }
                if (i == c.length - 1) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
