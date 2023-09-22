package inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public ArrayList<Integer> solution(int n,int m, int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int p1=0, p2=0;
        ArrayList<Integer> result = new ArrayList<>();

        while (p1 < n && p2 < m) {
            if (arr1[p1] == arr2[p2]) {
                result.add(arr1[p1++]);
                p2++;
            }
            else if(arr1[p1] < arr2[p2]) p1++;
            else p2++;
        }
//        int[] ch = new int[Math.max(arr1[n-1], arr2[m-1]) + 1];
//
//        for (int i = 0; i < n; i++) {
//            ch[arr1[i]]++;
//        }
//        for (int i = 0; i < m; i++) {
//            ch[arr2[i]]++;
//        }
//
//        for (int i = 1; i < ch.length; i++) {
//            if (ch[i] == 2) {
//                result.add(i);
//            }
//        }

        return result;
    }



    public static void main(String[] args) {
        Main M = new Main();
        Scanner in=new Scanner(System.in);
        int[] arr1, arr2;

        int input1 = in.nextInt();
        arr1 = new int[input1];

        for (int i = 0; i < input1; i++) {
            arr1[i] = in.nextInt();
        }

        int input2 = in.nextInt();
        arr2 = new int[input2];

        for (int i = 0; i < input2; i++) {
            arr2 [i] = in.nextInt();
        }

        for (int x :M.solution(input1, input2, arr1, arr2)) {
            System.out.print(x + " ");
        }
    }
}
