package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

//문제 풀이용
public class Main {
    public static void main(String[] args) {
        Queue<Integer> Q = new LinkedList<>();

//        Stack<Integer> Q = new Stack<>();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        int last = 0;
        for (int i = 0; i <= N; i++) {
            String s = sc.nextLine();
            String[] command = s.split(" ");
            if (command[0].equals("push")) {
                int v = Integer.parseInt(command[1]);
                last = v;
                Q.add(v);
            } else if (command[0].equals("front")) {
                sb.append(Q.isEmpty() ? -1 : Q.peek()).append("\n");
            } else if (command[0].equals("size")) {
                sb.append(Q.size()).append("\n");
            } else if (command[0].equals("empty")) {
                sb.append(Q.isEmpty() ? 1 : 0).append("\n");
            } else if (command[0].equals("pop")) {
                sb.append(Q.isEmpty() ? -1 : Q.poll()).append("\n");
            } else if(command[0].equals("back")) {
                sb.append(Q.isEmpty() ? -1 : last).append("\n");
            }
        }

        System.out.println(sb);
    }

}
