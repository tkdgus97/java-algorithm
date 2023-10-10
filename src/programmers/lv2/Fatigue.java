package programmers.lv2;

public class Fatigue {
    static boolean[] visited;
    static int count = 0;
    public void DFS(int depth, int fati, int[][] dungeon) {
        for (int i = 0; i < dungeon.length; i++) {
            if (visited[i] || fati < dungeon[i][0]) {
                continue;
            }
            visited[i] = true;
            DFS(depth + 1, fati - dungeon[i][1], dungeon);
            visited[i] = false;
        }
        count = Math.max(count, depth);
    }

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        DFS(0,k, dungeons);
        return count;
    }
}
