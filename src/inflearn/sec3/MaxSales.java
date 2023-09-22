package inflearn.sec3;

//슬라이딩 윈도우
public class MaxSales {
    public int solution(int n, int k, int[] arr) {
        int max = 0, sum = 0;
        for (int i = 0; i < k; i++) {
            max += arr[i];
        }
        sum = max;

        for (int i = k; i < n-k; i++) {
            sum += (arr[i] - arr[i-k]);
            max = Math.max(max, sum);
        }

        return max;
    }
}
