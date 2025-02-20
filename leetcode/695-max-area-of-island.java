class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1)
                    ans = Math.max(ans, dfsArea(grid, r, c));
            }
        }
        return ans;
    }

    private int dfsArea(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] == 0)
            return 0;
        int count = 1;
        grid[r][c] = 0;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int[] dir : dirs) {
            count += dfsArea(grid, r + dir[0], c + dir[1]);
        }
        return count;
    }
}