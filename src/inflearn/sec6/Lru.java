package inflearn.sec6;

import java.util.Scanner;

public class Lru {
    public static int[] soulutio(int size, int[] arr){
        int[] result = new int[size];

        for (int x : arr) {
            int l = -1;
            for (int i = 0; i < size; i++) {
                if (result[i] == x) {
                    l = i;
                }
            }

            if (l == -1) {
                for (int i = size-1; i > 0 ; i--) {
                    result[i] = result[i-1];
                }
            } else {
                for (int i = l; i > 0 ; i--) {
                    result[i] = result[i-1];
                }
            }
            result[0] = x;
        }

        return result;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        for (int v : soulutio(s, arr)) {
            System.out.print(v + " ");
        }
    }
}
