import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>(); // r,c

        int fresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    fresh++;
                if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j });
                }
            }
        }

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int time = 0;
        while (q.size() > 0 && fresh > 0) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if (r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] != 1)
                        continue;
                    grid[r][c] = 2;
                    q.offer(new int[] { r, c });
                    fresh--;
                }

            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}