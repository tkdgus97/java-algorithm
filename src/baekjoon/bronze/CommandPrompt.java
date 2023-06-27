package baekjoon.bronze;

import java.util.Scanner;

/**
 * 1032번
 */
public class CommandPrompt {

    public static String solution(int size, String[] names) {
        if (size == 1) {
            return names[0];
        }

        char[] result = names[0].toCharArray();

        for (int i = 1; i < size; i++) {
            char[] tmp = names[i].toCharArray();
            for (int j = 0; j < result.length; j++) {
                if (result[j] != tmp[j]) {
                    result[j] = '?';
                }
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();
        String[] fileNames = new String[size];

        for (int i = 0; i < size; i++) {
            fileNames[i] = in.next();
        }

        System.out.println(solution(size, fileNames));
    }
}
