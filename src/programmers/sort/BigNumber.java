package programmers.sort;
import java.util.Arrays;
import java.util.Comparator;

public class BigNumber {

    public void soulution(int[] numbers){
        String answer = "";
        String[] arr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });

        for (String s : arr) {
            answer += s;
        }
    }


    public static void main(String[] args) {
        BigNumber M = new BigNumber();

        M.soulution(new int[]{6,10,2});
    }
}

// 10 6 610 106
// 10 2