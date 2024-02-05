import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493_탑 {
	/**
	 * 1. 입력 받음
	 * 2. 뒤에서 부터 높이를 확인
	 * 3. stack에서 peek를 하며 만약 peek한 값의 높이가 현재 높이보다 작을 경우 
	 *    stack에서 현재 높이보다 작은 탑을 제거하면서 result 배열에 업데이트
	 */
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<int[]> stack = new Stack<>();
		int[] result = new int[N + 1];
		
		for (int i = N; i > 0; i--) {
			if (stack.isEmpty()) {
				stack.push(new int[] {arr[i], i});
				continue;
			} 
			
			int[] top = stack.peek();
			if (top[0] < arr[i]) {
				while(!stack.isEmpty()) {
					if (stack.peek()[0] > arr[i]) {
						break;
					}
					
					int[] now = stack.pop();
					result[now[1]] = i;
				}
				stack.push(new int[] {arr[i], i});
			} else {
				stack.push(new int[] {arr[i], i});
			}
		}
		
		for (int l = 1; l <= N; l++) {
			sb.append(result[l]).append(" ");
		}
		System.out.println(sb);
	}
}
