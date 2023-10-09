package programmers.lv1;

public class MinRectangle {
    public int solution(int[][] sizes) {
        int maxX = 0;
        int maxY = 0;

        //가로 세로 중 가장 긴 부분을 가로로 취급
        for (int i = 0; i < sizes.length; i++) {
            int x = Math.max(sizes[i][0], sizes[i][1]);
            int y = Math.min(sizes[i][0], sizes[i][1]);

            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
        }
        return maxX * maxY;
    }
}
