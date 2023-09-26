package inflearn.sec3;

import java.util.ArrayList;

//투포인터 알고리즘
public class CombineArr {
    public ArrayList<Integer> solution(int n,int m, int[] arr1, int[] arr2) {
        int p1 = 0;
        int p2 = 0;
        ArrayList<Integer> result = new ArrayList();

        while(p1 < n && p2 < m) {
            if (arr1[p1] < arr2[p2]) {
                result.add(arr1[p1++]);
            } else {
                result.add(arr2[p2++]);
            }
        }

        while(p1 < n) {
            result.add(arr1[p1++]);
        }

        while(p2 < m) {
            result.add(arr2[p2++]);
        }
        return result;
    }


}
