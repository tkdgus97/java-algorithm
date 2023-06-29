package programmers.que;

import java.util.Scanner;
import java.util.Stack;

public class CraneDoll {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> bucket = new Stack<>();
        //peek 시에 최초에는 아무것도 없기 때문에 0을 넣어줌
        bucket.push(0);

        for (int move : moves) {
            //move의 값들은 배열 인덱스에서 +1 된 값들이기때문
            int cur = move - 1;
            for (int j = 0; j < board.length; j++) {
                //cur로 현재 뽑기손이 위치한 곳 고정 후 j로 내려가면서 있는지 0이 아닌지 확인
                if (board[j][cur] != 0) {
                    //스택의 제일 위에 값 조회(pop이랑 다름 peek는 값만 return pop은 빼면서 값 return)
                    if (board[j][cur] == bucket.peek()) {
                        //같다면 넣을 필요없이 pop만 해주고 answer + 2 -> 문제에서 터진 인형의 개수를 물어봤기 때문에 2개가 동시에 사라지기 때문
                        bucket.pop();
                        answer += 2;
                    } else {
                        bucket.push(board[j][cur]);
                    }
                    board[j][cur] = 0;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] v1 = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] m = {1,5,3,5,1,2,1,4};
        solution(v1, m);
    }
}
