import java.util.*;

class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] visit = new boolean[n][n];
        Queue<int[]> q = new ArrayDeque<>();

        boolean found = false;
        for (int r = 0; r < n; r++) {
            if (found)
                break;
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    dfsIsland(grid, visit, r, c, q);
                    found = true;
                    break;
                }
            }
        }

        return bfsMultisource(grid, visit, q);
    }

    private boolean checkInvalid(int r, int c, int n) {
        return r < 0 || c < 0 || r >= n || c >= n;
    }

    private void dfsIsland(int[][] grid, boolean[][] visit, int r, int c, Queue<int[]> q) {
        if (checkInvalid(r, c, grid.length) || grid[r][c] == 0 || visit[r][c])
            return;

        visit[r][c] = true;
        q.offer(new int[] { r, c });

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] dir : dirs)
            dfsIsland(grid, visit, r + dir[0], c + dir[1], q);
    }

    private int bfsMultisource(int[][] grid, boolean[][] visit, Queue<int[]> q) {
        int ans = 0;
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if (checkInvalid(r, c, grid.length) || visit[r][c])
                        continue;

                    if (grid[r][c] == 1)
                        return ans; // Found second island

                    q.offer(new int[] { r, c });
                    visit[r][c] = true;
                }
            }
            ans++;
        }
        return -1;
    }
}
