package inflearn.sec3;

public class ContinueSum2 {
    public int solution(int n) {
        int result = 0, sum = 0, lt= 1;

        int[] arr = new int[n + 1];
        for (int i = 1; i < n; i++) {
            arr[i] = i;
        }

        for(int rt = 1; rt < n; rt++) {
            sum += arr[rt];
            if (sum == n) {
                result++;
            }
            while(sum >= n) {
                sum -= arr[lt++];
                if (sum == n) {
                    result++;
                }
            }
        }

        return result;
    }
}
