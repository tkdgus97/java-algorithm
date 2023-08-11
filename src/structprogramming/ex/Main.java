package structprogramming.ex;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] kors = new int[3];

        boolean keepLoop = true;

        Scanner scan = new Scanner(System.in);

        while (keepLoop) {
            switch (selectMenu(scan)) {
                case 1:
                    inputGrade(kors, scan);
                    break;
                case 2:
                    printGrade(kors);
                    break;
                case 3:
                    System.out.println("Bye~~");

                    keepLoop = false;
                    break;

                default:
                    System.out.println("잘못된 값을 입력하셨습니다. 메뉴는 1~3까지입니다.");
            }
        }
    }

    public static void inputGrade(int[] kors, Scanner scan) {
        print("성적 입력");

        for (int i = 0; i < 3; i++) {
            do {
                System.out.printf("국어%d : ", i + 1);
                kors[i] = scan.nextInt();

                if (kors[i] < 0 || 100 < kors[i]) {
                    System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");
                }
            } while (kors[i] < 0 || 100 < kors[i]);
        }

        System.out.println("────────────────────────");
    }

    public static void printGrade(int[] kors) {
        int total = 0;
        for (int i = 0; i < 3; i++) {
            total += kors[i];
        }
        double avg = total / 3.0f;
        
        print("성적 출력");

        for (int i = 0; i < 3; i++) {
            System.out.printf("국어 %d : %3d\n", 3 - i, kors[i]);
        }
        System.out.printf("총점 : %3d\n", total);
        System.out.printf("평균 : %6.2f\n", avg);
        System.out.println("────────────────────────");
    }

    public static int selectMenu(Scanner scan) {
        print("메인 메뉴");
        System.out.println("\t1. 성적입력 ");
        System.out.println("\t2. 성적출력 ");
        System.out.println("\t3. 종료 ");
        System.out.println("\t선택> ");
        return scan.nextInt();
    }

    public static void print(String s) {
        System.out.println("┌──────────────────┐");
        System.out.println("│     " + s + "    │");
        System.out.println("└──────────────────┘");
        System.out.println();
    }
}
