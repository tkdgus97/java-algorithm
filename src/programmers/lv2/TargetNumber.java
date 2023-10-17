package programmers.lv2;

public class TargetNumber {
    static int cnt = 0;

    public int solution(int[] numbers, int target) {
        int answer = 0;
        DFS(numbers, 0, 0, target);
        System.out.println(cnt);
        return answer;
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
}
