package programmers.lv1;

import inflearn.Main;

public class WalkPark {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {0, 0};
        int nx = 0, ny = 0;
        int x = park[0].length(), y = park.length;

        for (int i = 0; i < park.length; i++) {
            if (park[i].contains("S")) {
                ny = i;
                nx = park[i].indexOf("S");
            }
        }

        for (int i = 0; i < routes.length; i++) {
            String[] r = routes[i].split(" ");
            int len = Integer.parseInt(r[1]);
            int tmpX = nx;
            int tmpY = ny;
            for (int j = 0; j < len; j++) {
                if (r[0].equals("N")) {
                    tmpY--;
                }
                if (r[0].equals("S")) {
                    tmpY++;
                }
                if (r[0].equals("W")) {
                    tmpX--;
                }
                if (r[0].equals("E")) {
                    tmpX++;
                }

                if ((tmpX < 0 || tmpY < 0) || (tmpX >= x || tmpY>= y) || park[tmpY].charAt(tmpX) == 'X') {
                    break;
                }
                if (j == len - 1) {
                    nx = tmpX;
                    ny = tmpY;
                }
            }
        }
        answer[0] = ny;
        answer[1] = nx;

        return answer;
    }

    public static void main(String[] args) {
        WalkPark M = new WalkPark();
        M.solution(new String[]{"OSO", "OOO", "OXO", "OOO"}, new String[]{"E 2", "S 3", "W 1"});
    }
}
