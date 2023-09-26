package programmers.lv1;

import inflearn.Main;

public class Wallpaper {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        int minX, minY, maxX, maxY;

        minX = minY = Integer.MAX_VALUE;
        maxX = maxY = Integer.MIN_VALUE;

        int x = wallpaper[0].length();
        int y = wallpaper.length;

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }


        return new int[]{minX, minY, maxX + 1, maxY + 1};
    }

    public static void main(String[] args) {
        Main M = new Main();
//        M.solution(
//            new String[]{".#...", "..#..", "...#."});
    }
}
