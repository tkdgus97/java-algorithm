package inflearn.sec3;

import inflearn.Main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CommonNumber {
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

}
