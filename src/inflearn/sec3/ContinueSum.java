package inflearn.sec3;


//연속 수열의 합
public class ContinueSum {
    public int solution(int n, int k, int[] arr) {
        int result = 0, sum = 0, lt= 0;

        for(int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == k) {
                result++;
            }
            while(sum >= k) {
                sum -= arr[lt++];
                if (sum == k) {
                    result++;
                }
            }
        }

        return result;
    }
}
