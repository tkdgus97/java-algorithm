package baekjoon.gold;

import baekjoon.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17471_게리맨더링 {
    private static int result = Integer.MAX_VALUE;

    private static class Node {
        int popul;
        int guNum;
        List<Integer> nodes;

        public Node(int popul) {
            this.popul = popul;
            this.nodes = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                int area = Integer.parseInt(st.nextToken());
                nodes[i].nodes.add(area);
                nodes[area].nodes.add(i);
            }
        }

        pm(1, N, nodes);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
//        System.out.println(sb);
    }

    private static void pm(int L, int N, Node[] nodes) {
        if (L == N + 1) {
            int check = 0;
            int fGu = 0;
            int sGu = 0;
            for (int i = 1; i <= N; i++) {
                if (nodes[i].guNum == 0) {
                    fGu += nodes[i].popul;
                } else {
                    sGu += nodes[i].popul;
                }
            }

            boolean[] visit = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    setGu(nodes[i], N, visit, nodes);
                    check++;
                }
            }
            if (check == 2) {
                result = Math.min(Math.abs(fGu - sGu), result);
            }
            return;
        }
        nodes[L].guNum = 0;
        pm(L + 1, N, nodes);
        nodes[L].guNum = 1;
        pm(L + 1, N, nodes);
    }

    private static void setGu(Node start, int N, boolean[] visit, Node[] nodes) {
        Queue<Node> Q = new ArrayDeque<>();
        Q.add(start);
        while (!Q.isEmpty()) {
            Node now = Q.poll();
            for (int i = 0; i < now.nodes.size(); i++) {
                if (nodes[now.nodes.get(i)].guNum == now.guNum && !visit[now.nodes.get(i)]) {
                    visit[now.nodes.get(i)] = true;
                    Q.add(nodes[now.nodes.get(i)]);
                }
            }
        }
    }
}
