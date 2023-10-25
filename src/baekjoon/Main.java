package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//문제 풀이용
public class Main {
//    static int[] dx = {-1, 1, 0, 0};
//    static int[] dy = {0, 0, -1, 1};
//    static int[][] map, dis;
//    static boolean[][] visit;
//    static int N,M, res, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        ArrayList<Tmp> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Tmp(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(list);
        System.out.println();
    }

    public static void BFS(int x, int y){
    }

    static class Tmp implements Comparable<Tmp> {
        int price;
        int day;

        public Tmp(int price, int day) {
            this.price = price;
            this.day = day;
        }

        @Override
        public int compareTo(Tmp o) {
            if (o.day == this.day) {
                return o.price - this.price;
            }
            return o.day - this.day;
        }
    }
}
