package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

//문제 풀이용
public class Main {

    static int[] map;
    static boolean[] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, res;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N];

//        for (int i = 0; i < N; i++) {
//            map[i] = sc.nextInt();
//        }



    }


    public static void DFS(int[] numbers, int depth, int sum, int target) {
        if (depth == numbers.length) {
            if (sum == target) {
                cnt++;
            }
            return;
        }

        DFS(numbers, depth + 1, sum + numbers[depth], target);
        DFS(numbers, depth + 1, sum - numbers[depth], target);

    }

    public static void BFS(int x, int y) {
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
