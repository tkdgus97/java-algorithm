package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ5397_키로거 {
//    public static void main(String[] args) throws IOException {
//        StringBuilder sb = new StringBuilder();
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int T = Integer.parseInt(st.nextToken());
//
//        for (int tc = 0; tc < T; tc++) {
//            st = new StringTokenizer(br.readLine());
//
//            char[] input = st.nextToken().toCharArray();
//
//            LinkedList<Character> list = new LinkedList<>();
//            int nowIdx = 0;
//            for (int i = 0; i < input.length; i++) {
//                if (input[i] == '<') {
//                    if (nowIdx > 0) {
//                        nowIdx -= 1;
//                    }
//                    continue;
//                } else if (input[i] == '>') {
//                    if (nowIdx < list.size()) {
//                        nowIdx += 1;
//                    }
//                    continue;
//                } else if (input[i] == '-') {
//                    if (nowIdx > 0) {
//                        list.remove(nowIdx - 1);
//                        nowIdx -= 1;
//                    }
//                    continue;
//                }
//                list.add(nowIdx, input[i]);
//                nowIdx += 1;
//
//            }
//
//            for (Character c : list) {
//                sb.append(c);
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb);
//    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < T; tc++) {
            StringBuilder tmp = new StringBuilder();
            Stack<Character> inserStack = new Stack<>();
            Stack<Character> delStack = new Stack<>();

            st = new StringTokenizer(br.readLine());
            char[] input = st.nextToken().toCharArray();

            for (int i = 0; i < input.length; i++) {
                switch (input[i]) {
                    case '<' :
                        if (!inserStack.isEmpty()) {
                            delStack.add(inserStack.pop());
                        }
                        break;
                    case '>' :
                        if (!delStack.isEmpty()) {
                            inserStack.add(delStack.pop());
                        }
                        break;
                    case '-'  :
                        if (!inserStack.isEmpty()) {
                            inserStack.pop();
                        }
                        break;
                    default :
                        inserStack.add(input[i]);
                }
            }

            while (!delStack.isEmpty()) {
                inserStack.add(delStack.pop());
            }

            for (int i = 0; i < inserStack.size(); i++) {
                tmp.append(inserStack.get(i));
            }
            sb.append(tmp).append("\n");
        }
        System.out.println(sb);
    }
}
