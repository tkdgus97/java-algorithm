package programmers.que;

import java.util.LinkedList;
import java.util.Queue;

public class Proc {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        //우선순위 큐
        Queue<Integer> prio = new LinkedList<>();
        //위치 즉 location 큐
        Queue<Integer> idx = new LinkedList<>();

        //우선순위 큐는 그대로 넣고, location은 순서대로 초기화
        for (int i = 0; i < priorities.length; i++) {
            prio.add(priorities[i]);
            idx.add(i);
        }

        int maxVal = findMax(prio);  //1.최고 순위 값 조회
        int cnt = 0;  //cnt는 빠진 순서다 첫번재로 빠지면 1 두번째로 빠지면 2 ...

        while(!prio.isEmpty()) {
            //2. 우선순위 최고값 보다 작을 경우
            if (prio.peek() < maxVal) {
                //우선순위 큐에서 빼서 뒤로 보낸다. location의 값도 동시에 뒤로 보낸다.
                prio.offer(prio.poll());
                idx.offer(idx.poll());
            } else if (prio.peek() == maxVal) { //3. 우선순위 최고값과 같을 경우
                prio.poll(); //최고 우선순위 뺌
                int now = idx.poll(); //위치 확인
                cnt++; //cnt 증가 빠졌으니까
                //찾고자 하는 locaiton과 같을경우 몇번째로 빠졌는지(cnt) 할당 후 break;
                if (now == location) {
                    answer = cnt;
                    break;
                }

                // 그게 아니라면 우선순위 최고값 갱신 후 다시 while문 위로
                maxVal = findMax(prio);
            }
        }

        return answer;
    }

    //우선순위 최고값 찾는 메소드
    private int findMax(Queue<Integer> priorities) {
        int max = Integer.MIN_VALUE;
        for (int v : priorities) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ar = {2, 1, 3, 2};
        Proc p = new Proc();

        System.out.println(p.solution(ar, 2));
    }
}
