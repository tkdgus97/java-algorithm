package baekjoon.silver;

public class SelfNumber {
    public void solution() {
        int[] ch = new int[10036];
        int c = 1;
        while(c <= 10000) {
            char[] a = String.valueOf(c).toCharArray();
            int tmp = 0;
            for (char x : a) tmp += Character.getNumericValue(x);

            ch[c + tmp] = c + tmp;
            c++;
        }

        for (int i = 1; i <= 10000; i++) {
            if (ch[i] == 0) System.out.println(i);
        }
    }
}
