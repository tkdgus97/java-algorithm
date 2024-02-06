package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        int[][] map = new int[105][105];

        for (int i = 0; i < rectangle.length; i++) {
            //1 ,1 
            int x1 = rectangle[i][0] * 2, y1 = rectangle[i][1]* 2;
            //7, 4
            int x2 = rectangle[i][2]* 2, y2 = rectangle[i][3]* 2;

            for (int j = x1; j <= x2 ; j++) {
                if (map[y1][j] == 1 && map[y2][j] == 1) {
                    continue;
                }
                if(map[y1][j] == 1) {
                    map[y2][j] = 2;
                    continue;
                }
                if(map[y2][j] == 1) {
                    map[y1][j] = 2;
                    continue;
                }
                map[y2][j] = 2;
                map[y1][j] = 2;
            }

            for (int j = y1; j <= y2; j++) {
                if (map[j][x1] == 1 && map[j][x2] == 1) {
                    continue;
                }

                if(map[j][x1] == 1) {
                    map[j][x2] = 2;
                    continue;
                }

                if(map[j][x2] == 1) {
                    map[j][x1] = 2;
                    continue;
                }
                map[j][x1] = 2;
                map[j][x2] = 2;
            }

            for (int j = y1 + 1; j < y2; j++) {
                for (int j2 = x1 + 1; j2 < x2; j2++) {
                    map[j][j2] = 1;
                }

            }
        }

        answer = bfs(characterY * 2, characterX * 2, map, itemY * 2, itemX * 2) / 2;


        return answer;
    }

    private static int bfs(int start, int end, int[][] map, int findX, int findY) {
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,-1,0,1};
        boolean[][] visit = new boolean[102][102];

        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[]{start, end, 0});
        visit[start][end] = true;

        int result = Integer.MAX_VALUE;
        while(!Q.isEmpty()) {
            int[] now = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx == findX && ny == findY) {
                    result = Math.min(result, now[2] + 1);
                    break;
                }

                if ((nx>=0 && nx < 102) && (ny >= 0 && ny < 102) && map[nx][ny] == 2 && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    Q.add(new int[]{nx, ny, now[2] + 1});
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int re = s.solution(new int[][] {{1,1,7,4},{3,2,5,5},{4,3,6,9}, {2,6,8,8}}, 1, 3, 7, 8);
        System.out.println(re);

    }
}