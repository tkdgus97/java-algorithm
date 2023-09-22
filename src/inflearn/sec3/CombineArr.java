package inflearn.sec3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javastudy.Main;

//투포인터 알고리즘
public class CombineArr {
    public ArrayList<Integer> solution(int n,int m, int[] arr1, int[] arr2) {
        int p1 = 0, p2 = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (p1 < n && p2 < m) {
            if (arr1[p1] < arr2[p2]) {
                result.add(arr1[p1++]);
            } else {
                result.add(arr2[p2++]);
            }
        }

        while (p1 < n) {
            result.add(arr1[p1++]);
        }
        while (p2 < m) {
            result.add(arr2[p2++]);
        }
        return result;
    }



    public static void main(String[] args) {
        CombineArr M = new CombineArr();
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
