package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static int result;

    private static class Person {
        int x;
        int y;
        int time;

        public Person(int x, int y) {
            this.x = x;
            this.y = y;
            this.time = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= T; tc++) {
            result = 0;
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];
            List<Person> people = new LinkedList<>();

            int[][] out = new int[2][2];
            out[0][0] = out[1][0] = -1;
            int pIdx = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] == 1) people.add(new Person(i,j));
                    if (arr[i][j] > 1) {
                        if (out[0][0] == -1) {
                            out[0][0] = i;
                            out[0][1] = j;
                        } else {
                            out[1][0] = i;
                            out[1][1] = j;
                        }
                    }
                }
            }


            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);

    }
    private static void pm(int L, int[] pmArr, int[][] out, List<Person> people) {
        if (L == pmArr.length) {
            return;
        }
        pmArr[L] = 1;
        pm(L + 1, pmArr, out, people);
        pmArr[L] = 0;
        pm(L + 1, pmArr, out, people);
    }

    private static int simul(int[] pmArr, int[][] out, List<Person> people) {
        int time = 0;
        List<Person> p = new ArrayList<>();
        p.addAll(people);
        while(true) {


            break;
        }
        return time;
    }
}