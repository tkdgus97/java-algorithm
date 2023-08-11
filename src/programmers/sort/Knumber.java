package programmers.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Knumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            List<Integer> subList = new ArrayList<>();
            for (int j = commands[i][0] - 1; j <= commands[i][1] - 1; j++) {
                subList.add(array[j]);
            }

            Collections.sort(subList);

            answer[i] = subList.get(commands[i][2] - 1);
        }

        return answer;
    }
    // {5,7,3,9,0}
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Knumber M = new Knumber();
        M.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});

    }
}
