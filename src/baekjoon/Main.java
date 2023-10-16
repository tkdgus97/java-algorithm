package baekjoon;

import java.util.Scanner;

//문제 풀이용
public class Main {

    //    public static String sol(int n, int k) {
//        return null;
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] s = sc.nextLine().split(" ");

        int year = Integer.parseInt(s[2]);
        int totalDay = 365;
        int month = 0;
        //윤년 체크
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            totalDay += 1;
        }

        int totalMin = totalDay * 24 * 60 * 60 ;
        //무슨 월인지 체크
        for (int i = 0; i < months.length; i++) {
            if (months[i].equals(s[0])) {
                month = i + 1;
                break;
            }
        }
        int tmpDay = 0;
        String[] t = s[3].split(":");
        int tmpMin =((Integer.parseInt(t[0])*60)+ Integer.parseInt(t[1])) * 60;
        for (int i = 1; i < month; i++) {
            if (i == 2) {
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    tmpDay += 1;
                }
            }
            tmpDay += days[i - 1];
        }
        tmpDay += Integer.parseInt(s[1].replace(",", "")) - 1;
        int tmpTotalMin = (tmpDay * 24 * 60 * 60) + tmpMin;


        System.out.println((double)((double) tmpTotalMin / (double) totalMin) * 100);
    }

}
