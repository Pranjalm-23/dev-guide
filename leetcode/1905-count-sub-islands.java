import java.util.*;

class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows = grid1.length;
        int cols = grid1[0].length;
        Set<String> visit = new HashSet<>();

        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid2[i][j] == 1 && !visit.contains(i + " " + j) && dfs(grid1, grid2, i, j, visit)) {
                    ans += 1;
                }
            }
        }
        return ans;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int r, int c, Set<String> visit) {
        if (r < 0 || c < 0 || r >= grid1.length || c >= grid1[0].length || grid2[r][c] == 0
                || visit.contains(r + " " + c)) {
            return true;
        }

        visit.add(r + " " + c);
        boolean isSubIsland = grid1[r][c] == 1;

        // DFS in all four directions
        isSubIsland = dfs(grid1, grid2, r + 1, c, visit) && isSubIsland;
        isSubIsland = dfs(grid1, grid2, r - 1, c, visit) && isSubIsland;
        isSubIsland = dfs(grid1, grid2, r, c + 1, visit) && isSubIsland;
        isSubIsland = dfs(grid1, grid2, r, c - 1, visit) && isSubIsland;

        return isSubIsland;
    }
}