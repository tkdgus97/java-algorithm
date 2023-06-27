package inflearn.sec2;

import java.util.Scanner;

public class Main {
    public static int solution(int size, int[][] arr) {
        int result = 0;

        for (int i = 0; i < size; i++) {
            
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();
        int[][] mountArr = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mountArr[i][j] = in.nextInt();
            }
        }

        System.out.println(solution(size, mountArr));
    }
}
